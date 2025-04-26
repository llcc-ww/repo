package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
//@Setter
@NoArgsConstructor //기본생성자 자동 생성
public class Board {
    @Id  //엔티티에서 각 데이터들을 구분하기 위해 필요
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    //게시글 수정 메소드
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
