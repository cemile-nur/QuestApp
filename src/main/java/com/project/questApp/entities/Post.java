package com.project.questApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "post")
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue
    int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    //  @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;


    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;

}
