package com.example.demo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Board {
    @Id  //엔티티에서 각 데이터들을 구분하기 위해 필요
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
}
