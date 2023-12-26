package com.project.questApp.responses;

import com.project.questApp.entities.Comment;
import lombok.Data;

@Data
public class CommentResponse {
    int id;
    int userId;
    String name;
    String text;
    public CommentResponse(Comment entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.name = entity.getUser().getName();
        this.text = entity.getText();
    }
}
