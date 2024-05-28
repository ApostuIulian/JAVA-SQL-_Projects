package com.example.ProiectPS.Service;

import com.example.ProiectPS.DTOs.ForumDto;
import com.example.ProiectPS.DTOs.PostDto;
import com.example.ProiectPS.Model.Forum;
import com.example.ProiectPS.Model.Post;
import com.example.ProiectPS.Repositories.ForumRepository;
import com.example.ProiectPS.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ForumServiceImpl implements ForumService{

    @Autowired
    private ForumRepository forumRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Forum save(ForumDto forumDto) {
        Forum forum = new Forum(forumDto.getTitle(), forumDto.getText(), forumDto.getUserName());
        return forumRepository.save(forum);
    }

    @Override
    public Post save(PostDto postDto) {
        Post post = new Post(postDto.getForumId(), postDto.getUserName(), postDto.getMessage());
        return postRepository.save(post);
    }

    @Override
    public Forum update(Forum Forum) {
        return forumRepository.save(Forum);
    }

    @Override
    public List<Forum> findAll() {
        return forumRepository.findAll(Sort.by(Sort.Direction.DESC, "addedDate"));
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    @Override
    public List<Post> findPostsInForum(Long forumId) {
        return postRepository.findAllByForumId(forumId);
    }

    @Override
    public Optional<Forum> findById(Long id) {
        return forumRepository.findById(id);
    }

    @Override
    public List<Forum> findForumByName(String filter) {
        return forumRepository.findForumByName(filter);
    }
}
