package com.project.questApp.requests;

import lombok.Data;

@Data
public class PostCreateRequest {
    int id;
    String text;
    String title;
    int userId;
}
