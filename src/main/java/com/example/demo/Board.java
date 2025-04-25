package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
//@Setter
public class Board {
    @Id  //엔티티에서 각 데이터들을 구분하기 위해 필요
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    public Board(){}

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
