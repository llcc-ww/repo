package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void testJpa() {
        Board q1 = new Board();
        q1.setTitle("테스트 제목 1");
        q1.setContent("테스트 내용1");
        this.boardRepository.save(q1);  // 첫번째 질문 저장

        Board q2 = new Board();
        q2.setTitle("테스트 제목 2");
        q2.setContent("테스트 내용 2");
        this.boardRepository.save(q2);  // 두번째 질문 저장
    }

}
