package com.project.questApp.controllers;

import com.project.questApp.entities.Comment;
import com.project.questApp.requests.CommentCreateRequest;
import com.project.questApp.requests.CommentUpdateRequest;
import com.project.questApp.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Integer> userId,
                                        @RequestParam Optional<Integer> postId) {
        return commentService.getAllComments(userId, postId);
    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest request) {
        return commentService.createOneComment(request);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Integer commentId) {
        return commentService.getOneCommentById(commentId);
    }

    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Integer commentId, @RequestBody CommentUpdateRequest commentUpdateRequest) {
        return commentService.updateOneCommentById(commentId, commentUpdateRequest);
    }

    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Integer commentId) {
        commentService.deleteOneCommentById(commentId);
    }
}
