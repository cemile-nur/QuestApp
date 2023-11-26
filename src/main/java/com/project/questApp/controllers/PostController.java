package com.project.questApp.controllers;

import com.project.questApp.entities.Like;
import com.project.questApp.entities.Post;
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
    public List<Post> getAllPosts(@RequestParam Optional<Integer> userId){
        return postService.getAllPosts(userId);
    }


    @PostMapping
    public Post createOnePost(@RequestBody Post newPost){
        return postService.createOnePost(newPost);
    }
    @GetMapping("/{postId}")

    public Post getOnePost(@PathVariable Integer postId){
        return postService.getOnePostById(postId);
    }
}
