package com.project.questApp.controllers;

import com.project.questApp.entities.Post;
import com.project.questApp.requests.PostCreateRequest;
import com.project.questApp.requests.PostUpdateRequest;
import com.project.questApp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Integer> userId) {
        return postService.getAllPosts(userId);
    }


    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
        return postService.createOnePost(newPostRequest);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Integer postId) {
        return postService.getOnePostById(postId);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Integer postId, @RequestBody PostUpdateRequest updatePost) {
        return postService.updateOnePostById(postId,updatePost);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Integer postId) {
        postService.deleteOnePostById(postId);

    }
}
