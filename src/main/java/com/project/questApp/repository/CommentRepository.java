package com.project.questApp.repository;

import com.project.questApp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {


    List<Comment> findByUserIdAndPostId(Integer userId, Integer postId);

    List<Comment> findByUserId(Integer userId);

    List<Comment> findByPostId(Integer postId);
}
