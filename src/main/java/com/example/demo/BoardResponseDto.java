package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor

public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;


    //기본생성자
    public BoardResponseDto(){}

}
