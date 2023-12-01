package com.project.questApp.services;

import com.project.questApp.entities.Comment;
import com.project.questApp.entities.Post;
import com.project.questApp.entities.User;
import com.project.questApp.repository.CommentRepository;
import com.project.questApp.requests.CommentCreateRequest;
import com.project.questApp.requests.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Comment> getAllComments(Optional<Integer> userId, Optional<Integer> postId) {

        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        } else
            return commentRepository.findAll();
    }


    public Comment getOneCommentById(Integer commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest request) {

        User user = userService.getOneUserById(request.getUserId());
        Post post = postService.getOnePostById(request.getPostId());
        if (user != null && post != null) {
            Comment commentToSave = new Comment();
            commentToSave.setId(request.getId());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setText(request.getText());
            return commentRepository.save(commentToSave);
        } else
            return null;
    }

    public Comment updateOneCommentById(Integer commentId, CommentUpdateRequest request) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(request.getText());
            return commentRepository.save(commentToUpdate);
        } else
            return null;
    }

    public void deleteOneCommentById(Integer commentId) {
        commentRepository.deleteById(commentId);
    }
}
