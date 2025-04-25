package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> { //Board 엔티티로 리포지토리를 생성한다는 의미. Board 엔티티의 기본키 Integer
}
