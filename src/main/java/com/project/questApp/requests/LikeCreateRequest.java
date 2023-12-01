package com.project.questApp.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {
    int id;
    int userId;
    int postId;
}
