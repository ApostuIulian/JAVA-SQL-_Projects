package com.example.ProiectPS.Controller;

import com.example.ProiectPS.DTOs.SolvingDto;
import com.example.ProiectPS.DTOs.UserDto;
import com.example.ProiectPS.Model.Problem;
import com.example.ProiectPS.Model.User;
import com.example.ProiectPS.Repositories.UserRepository;
import com.example.ProiectPS.Service.CustomUserDetails;
import com.example.ProiectPS.Service.EmailSenderService;
import com.example.ProiectPS.Service.ProblemService;
import com.example.ProiectPS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    long userId;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProblemService problemService;

    @Autowired
    private EmailSenderService senderService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public  String registerPage(@ModelAttribute("user") UserDto userDto)
    {
        return "register";
    }

    @PostMapping("/register")
    public  String saveUser(@ModelAttribute("user") UserDto userDto, Model model)
    {
        userService.save(userDto);
        senderService.sendSimpleEmail(userDto.getEmail(), "Account registration!", "Success!");
        model.addAttribute("message", "Registered Successfully");
        return "register";
    }

    @GetMapping("/login")
    public  String loginPage()
    {
        return "login";
    }

    @GetMapping("/admin-page")
    public String adminMainPage(Model model)
    {
        List<Problem> problems = problemService.findAll();
        model.addAttribute("problems", problems);
        return "admin";
    }

    @GetMapping("/user-page")
    public String userMainPage(Model model, Principal principal, @ModelAttribute("solving") SolvingDto solvingDto)
    {
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(principal.getName());
        userId = userDetails.getId();
        List<Problem> problems = problemService.findRecentProblems();
        List<Problem> recentlyTried = problemService.findRecentlyTriedProblems(userId);
        model.addAttribute("recentProblems", problems);
        model.addAttribute("attemptedProblems", recentlyTried);
        return "user";
    }


    @GetMapping("/user-page/accountInfo")
    public String accountInfoPage(Model model, Principal principal)
    {
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(principal.getName());
        List<Problem> solvedProblems = problemService.findSolvedProblems(userId);

        model.addAttribute("problems", solvedProblems);
        model.addAttribute("name", userDetails.getFullName());
        model.addAttribute("email", userDetails.getUsername());
        model.addAttribute("username", userDetails.getUser());
        model.addAttribute("date", userDetails.getDate());
        model.addAttribute("solvedNr", solvedProblems.size());
        return "accountInfo";
    }
}
