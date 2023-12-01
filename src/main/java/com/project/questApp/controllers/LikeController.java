package com.project.questApp.controllers;

import com.project.questApp.entities.Like;
import com.project.questApp.requests.LikeCreateRequest;
import com.project.questApp.services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<Like> getAllLikes(@RequestParam Optional<Integer> userId,
                                  @RequestParam Optional<Integer> postId) {
        return likeService.getAllComments(userId, postId);
    }

    @PostMapping
    public Like createOneLike(@RequestBody LikeCreateRequest request) {
        return likeService.createOnelike(request);
    }

    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Integer likeId) {
        return likeService.getOneLikeById(likeId);
    }

    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Integer likeId) {
        likeService.deleteOneLikeById(likeId);
    }
}
