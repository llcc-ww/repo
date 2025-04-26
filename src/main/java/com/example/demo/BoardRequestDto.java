package com.example.demo;

import lombok.Getter;

@Getter
public class BoardRequestDto { //새 글 등록하거나 수정하는 등, 클라이언트가 입력한 데이터 처리에 사용

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
