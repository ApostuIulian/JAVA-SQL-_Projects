package com.example.ProiectPS.Controller;
import com.example.ProiectPS.DTOs.ForumDto;
import com.example.ProiectPS.DTOs.PostDto;
import com.example.ProiectPS.Model.Forum;
import com.example.ProiectPS.Model.Post;
import com.example.ProiectPS.Service.CustomUserDetails;
import com.example.ProiectPS.Service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller

public class ForumController {

    @Autowired
    ForumService forumService;
    Long postId;

    @Autowired
    UserDetailsService userDetailsService;
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping("/user-page/forum")
    public String forumPage(@ModelAttribute("forum") ForumDto forumDto, Model model, @RequestParam(required = false)String filter) {
        List<Forum> forums;
        System.out.println(filter);
        if(filter != null)
        {
            forums = forumService.findForumByName(filter);
        }else
        {
            forums = forumService.findAll();
        }
        model.addAttribute("forums", forums);
        return "forum";
    }

    @PostMapping("/user-page/forum")
    public String createForum(@ModelAttribute("forum") ForumDto forumDto, Model model, Principal principal)
    {
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(principal.getName());
        String username = userDetails.getUser();
        forumDto.setUserName(username);
        //System.out.println(forumDto.getTitle());
        forumService.save(forumDto);
        return "redirect:/user-page/forum";
    }

    @GetMapping("/user-page/forum/post")
    public String postPage(@ModelAttribute("post") PostDto postDto, Model model, @RequestParam(required = true)Long id)
    {
        postId = id;
        System.out.println(id);
        Forum forum = forumService.findById(id).get();
        model.addAttribute("title", forum.getTitle());
        model.addAttribute("text", forum.getText());
        List<Post> posts = forumService.findPostsInForum(id);
        model.addAttribute("posts", posts);
        return "post";
    }

    @PostMapping("/user-page/forum/post")
    public String postMessage(@ModelAttribute("post") PostDto postDto, Model model, Principal principal)
    {
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(principal.getName());
        String username = userDetails.getUser();
        postDto.setUserName(username);
        postDto.setForumId(postId);
        forumService.save(postDto);
        return "redirect:/user-page/forum/post?id="+postId;
    }

}
