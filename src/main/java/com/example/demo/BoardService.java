package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service  //서비스 어노테이션을 붙이면 스프링부트가 해당 클래스를 서비스로 인식한다.
public class BoardService {

    private final BoardRepository boardRepository;

    //작성글 목록 가져오는 메소드 (엔티티만 사용했을 때 적었던 코드)
    /*
    public List<Board> getBoardList() {
        return this.boardRepository.findAll();
    }
    */

    //작성글 목록 DTO 객체에 담아서 가져오는 메소드
    public List<BoardResponseDto> getBoardDtoList() {
        List<Board> boardList = this.boardRepository.findAll();

        ArrayList<BoardResponseDto> boardDtoList = new ArrayList<>();

        for(Board temp : boardList) {
            BoardResponseDto boardDto= BoardResponseDto.builder()
                    .id(temp.getId())
                    .title(temp.getTitle())
                    .content(temp.getContent())
                    .build();

            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    //
    public BoardResponseDto getBoard(Integer id) {
        Optional<Board> board = this.boardRepository.findById(id);
        if (board.isPresent()) {
            Board temp=board.get(); //Optional에 들어있는 Board 객체를 가져와 반환
            //엔티티를 Dto로 바꿔서 반환
            BoardResponseDto boardDetail= BoardResponseDto.builder()
                    .id(temp.getId())
                    .title(temp.getTitle())
                    .content(temp.getContent())
                    .build();
            return boardDetail;

        } else {
            throw new DataNotFoundException("board not found");
        }
    }

    //새 글 디비에 저장
    public void createNewBoard(String title, String content) {
        BoardRequestDto requestDTO = new BoardRequestDto(title, content); // DTO 객체로 먼저 받기
        Board newBoard = requestDTO.toEntity(); //엔티티 객체로 변환
        this.boardRepository.save(newBoard); //디비에 저장
    }

    @Transactional
    public void updateBoard(Integer id, BoardRequestDto boardRequestDto) {
        Board board = this.boardRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("board not found"));
        board.update(boardRequestDto.getTitle(), boardRequestDto.getContent());
    }

    @Transactional
    public void deleteBoard(Integer id) {
        Board board=this.boardRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("board not found"));
        this.boardRepository.delete(board);
    }



}


