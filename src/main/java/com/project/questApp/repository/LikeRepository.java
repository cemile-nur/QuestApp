package com.project.questApp.repository;

import com.project.questApp.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {
    List<Like> findByUserIdAndPostId(Integer userId, Integer postId);

    List<Like> findByUserId(Integer userId);

    List<Like> findByPostId(Integer postId);
}
