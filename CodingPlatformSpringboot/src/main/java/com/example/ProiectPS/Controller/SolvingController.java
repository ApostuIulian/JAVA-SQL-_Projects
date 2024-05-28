package com.example.ProiectPS.Controller;

import com.example.ProiectPS.DTOs.SolvingDto;
import com.example.ProiectPS.Model.Problem;
import com.example.ProiectPS.Model.Solving;
import com.example.ProiectPS.Model.Test;
import com.example.ProiectPS.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.ProiectPS.Model.CompileCode.compileCpp;
import static com.example.ProiectPS.Model.CompileCode.compileJava;

@Controller
public class SolvingController {
    long userId;
    long problemId;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProblemService problemService;
    @Autowired
    private TestService testService;
    @Autowired
    private SolvingService solvingService;
    String result = "";

    @GetMapping("/user-page/solveProblem")
    public String solveProblemPage(Model model, Principal principal, @RequestParam long idProblem) {
        problemId = idProblem;
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(principal.getName());
        userId = userDetails.getId();
        model.addAttribute("solving", new SolvingDto(problemId, userId));


        Problem problem = problemService.findById(problemId).get();
        model.addAttribute("title", problem.getName());
        model.addAttribute("task", problem.getTask());
        model.addAttribute("message", result);
        Solving solving = solvingService.findSpecificSolving(problemId, userId);
        String code = "";
        try {
            code = solving.getCode();
        } catch (Exception e) {
            code = "";
            System.out.println(e);
        }
        System.out.println(code);
        model.addAttribute("submittedCode", code);
        result = "";
        return "solveProblem";
    }


    @GetMapping("/user-page/unsolvedProblems")
    public String unsolvedPage(Model model, Principal principal, @RequestParam(required = false)String filter, @RequestParam(required = false)String filterD) {
        List<Problem> unsolvedProblems;
        List<Problem> unsolvedByDifficulty = new ArrayList<>();
        //System.out.println(filterD);
        if(filter != null)
        {
            unsolvedProblems = problemService.findUnsolvedProblemsByName(filter, userId);
            //System.out.println(filter);
        }else
        {
                unsolvedProblems = problemService.findUnsolvedProblems(userId);
        }
        if(filterD != null)
        {
            if(!filterD.equals("all")) {
                for (Problem p : unsolvedProblems) {
                    if (p.getDifficulty().equals(filterD)) {
                        unsolvedByDifficulty.add(p);
                    }
                }
                model.addAttribute("problems", unsolvedByDifficulty);
            }else {
                model.addAttribute("problems", unsolvedProblems);
            }
        }else {
            model.addAttribute("problems", unsolvedProblems);
        }
        return "unsolvedProblems";
    }

    @PostMapping("/user-page/solveProblem")
    public String solveProblem(Model model, Principal principal, @ModelAttribute("solving") SolvingDto solvingDto, @RequestParam(required = false)String CppOrJ) {
        String code = solvingDto.getCode();
        int nrOfTestsPassed = 0;
        double score = 0;
        List<Test> tests = testService.findByProblemId(problemId);
        try {
            if(CppOrJ!=null) {
                for (Test test : tests) {
                    if(CppOrJ.equals("c")) {
                        result = compileCpp(code, test.getInput());
                    }else
                    {
                        result = compileJava(code, test.getInput());
                    }
                    if (result.equals(test.getOutput())) {
                        nrOfTestsPassed++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if(tests.size() > 0) {
            score = (nrOfTestsPassed / tests.size()) * 100;
            result = String.valueOf(score);
        }else
        {
            result = "This problem doesn't have any tests yet!";
            return "redirect:/user-page/solveProblem?idProblem=" + problemId;
        }
        solvingDto.setScore((int) score);
        solvingDto.setIdUser(userId);
        solvingDto.setCode(code);
        Solving solving = solvingService.findSpecificSolving(problemId, userId);
        if (solving != null && solving.getScore() <= score) {
            solving.setScore((int) score);
            solving.setCode(code);
            System.out.println(code);
            solving.setAddedDate(LocalDateTime.now());
            solvingService.update(solving);
        }
        if(solving == null){
            solvingService.save(solvingDto);
        }
        return "redirect:/user-page/solveProblem?idProblem=" + problemId;
    }
}
