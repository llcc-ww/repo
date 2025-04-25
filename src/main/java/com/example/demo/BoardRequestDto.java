package com.example.demo;

public class BoardRequestDto {

    private String title;
    private String content;

    //기본생성자
    public BoardRequestDto() {}

    public BoardRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    //엔티티로 변환
    public Board toEntity() {
        return new Board(this.title,this.content);
    }

}
