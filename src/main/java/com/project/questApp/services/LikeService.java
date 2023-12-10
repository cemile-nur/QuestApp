package com.project.questApp.services;

import com.project.questApp.entities.Like;
import com.project.questApp.entities.Post;
import com.project.questApp.entities.User;
import com.project.questApp.repository.LikeRepository;
import com.project.questApp.requests.LikeCreateRequest;
import com.project.questApp.responses.LikeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeService {
    private LikeRepository likeRepository;
    private UserService userService;
    private PostService postService;

    public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

  public List<LikeResponse> getAllLikesWithParam(Optional<Integer> userId, Optional<Integer> postId) {
        List<Like> list;
        if(userId.isPresent() && postId.isPresent()) {
            list = likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }else if(userId.isPresent()) {
            list = likeRepository.findByUserId(userId.get());
        }else if(postId.isPresent()) {
            list = likeRepository.findByPostId(postId.get());
        }else
            list = likeRepository.findAll();
        return list.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());
    }
    public List<Like> getAllComments(Optional<Integer> userId, Optional<Integer> postId) {

        if (userId.isPresent() && postId.isPresent()) {
            return likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return likeRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return likeRepository.findByPostId(postId.get());
        } else
            return likeRepository.findAll();
    }

    public Like getOneLikeById(Integer likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }

    public Like createOnelike(LikeCreateRequest request) {
        User user = userService.getOneUserById(request.getUserId());
        Post post = postService.getOnePostById(request.getPostId());
        if (user != null && post != null) {
            Like likeToSave = new Like();
            likeToSave.setId(request.getId());
            likeToSave.setPost(post);
            likeToSave.setUser(user);
            return likeRepository.save(likeToSave);
        } else
            return null;
    }

    public void deleteOneLikeById(Integer likeId) {
        likeRepository.deleteById(likeId);
    }
}
