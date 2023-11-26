package com.project.questApp.entities;

import jakarta.persistence.*;
import lombok.*;


@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "password")
    String password;
}
