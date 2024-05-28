package com.example.ProiectPS.Controller;

import com.example.ProiectPS.DTOs.ProblemDto;
import com.example.ProiectPS.DTOs.TestDto;
import com.example.ProiectPS.Model.Problem;
import com.example.ProiectPS.Model.Solving;
import com.example.ProiectPS.Model.Test;
import com.example.ProiectPS.Service.ProblemService;
import com.example.ProiectPS.Service.SolvingService;
import com.example.ProiectPS.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProblemController {
    @Autowired
    private ProblemService problemService;
    @Autowired
    private TestService testService;
    @Autowired
    private SolvingService solvingService;
    Long probId;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/admin-page/createProblem")
    public  String createProblemPage(@ModelAttribute("problem") ProblemDto problemDto)
    {
        return "createProblem";
    }

    @PostMapping("/admin-page/createProblem")
    public String saveProblem(@ModelAttribute("problem") ProblemDto problemDto, Model model)
    {
        problemService.save(problemDto);
        model.addAttribute("message", "Problem Added Successfully");
        return "redirect:/admin-page";
    }

    @GetMapping("/admin-page/editProblem")
    public  String editProblemPage(Model model, @RequestParam long id)
    {
        try {
            Problem problem = problemService.findById(id).get();
            model.addAttribute("problem", problem);
            ProblemDto problemDto = new ProblemDto(problem.getName(), problem.getTask(), problem.getDifficulty());
            model.addAttribute(problemDto);
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return "editProblem";
    }

    @PostMapping("/admin-page/editProblem")
    public  String updateProblem(Model model, @RequestParam long id, @ModelAttribute ProblemDto problemDto)
    {
        try{
            Problem problem = problemService.findById(id).get();
            model.addAttribute("problem", problem);
            problem.setName(problemDto.getName());
            problem.setTask(problemDto.getTask());
            problemService.update(problem);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return "redirect:/admin-page";
    }

    @GetMapping("/admin-page/deleteProblem")
    public String deleteProblem(@RequestParam long id)
    {
        try
        {
            Problem problem = problemService.findById(id).get();
            List<Test> tests = testService.findByProblemId(id);
            List<Solving> solvings = solvingService.findByProblemId(id);
            for(Test test: tests)
            {
                testService.delete(test);
            }
            for(Solving solving: solvings)
            {
                solvingService.delete(solving);
            }

            problemService.delete(problem);
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return "redirect:/admin-page";
    }

    @GetMapping("/admin-page/createTest")
    public  String createTestPage(Model model, @ModelAttribute("test") TestDto testDto, @RequestParam long id)
    {
        probId = id;
        return "createTest";
    }

    @PostMapping("/admin-page/createTest")
    public String saveTest(@ModelAttribute("test") TestDto testDto, Model model)
    {
        testDto.setIdProblem(probId);
        testService.save(testDto);
        model.addAttribute("message", "Test Added Successfully");
        return "redirect:/admin-page";
    }
}
