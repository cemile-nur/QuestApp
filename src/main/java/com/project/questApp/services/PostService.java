package com.project.questApp.services;

import com.project.questApp.entities.Post;
import com.project.questApp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(Optional<Integer> userId) {
        if (userId.isPresent())
            return postRepository.findByUserId(userId.get());
        return postRepository.findAll();
    }

    public Post getOnePostById(Integer postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(Post newPost) {
        return postRepository.save(newPost);
    }
}
