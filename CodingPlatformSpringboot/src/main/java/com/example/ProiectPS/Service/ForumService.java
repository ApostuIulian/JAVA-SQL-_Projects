package com.example.ProiectPS.Service;

import com.example.ProiectPS.DTOs.ForumDto;
import com.example.ProiectPS.DTOs.PostDto;
import com.example.ProiectPS.Model.Forum;
import com.example.ProiectPS.Model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ForumService {

    Forum save(ForumDto forumDto);
    Post save(PostDto postDto);
    Forum update(Forum forum);
    List<Forum> findAll();
    List<Post> findAllPosts();
    List<Post> findPostsInForum(Long forumId);

    Optional<Forum> findById(Long id);

    List<Forum> findForumByName(String filter);
}
