package com.project.questApp.responses;

import com.project.questApp.entities.Like;
import lombok.Data;

@Data
public class LikeResponse {
    int id;
    int userId;
    int postId;

    public LikeResponse(Like entity) {

        this.id = entity.getId();;
        this.userId =  entity.getUser().getId();;
        this.postId = entity.getPost().getId();;
    }
}
