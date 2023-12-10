package com.project.questApp.responses;

import com.project.questApp.entities.Like;
import com.project.questApp.entities.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
    int id;
    int userId;
    String userName;
    String title;
    String text;
    List<LikeResponse> postLikes;

    public PostResponse(Post entity, List<LikeResponse> likes) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getName();
        this.title = entity.getTitle();
        this.text = entity.getText();
        this.postLikes=likes;
    }
}
