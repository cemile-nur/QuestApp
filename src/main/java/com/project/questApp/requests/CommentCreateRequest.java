package com.project.questApp.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {
    int id;
    int userId;
    int postId;
    String text;
}
