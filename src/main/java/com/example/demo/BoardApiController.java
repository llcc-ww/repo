package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping("/api/board/list")
    @ResponseBody
    public List<BoardResponseDto> list() {
        return this.boardService.getBoardDtoList();  //json 형태로 값만 반환
    }

    @GetMapping(value="api/board/detail/{id}")
    @ResponseBody
    public BoardResponseDto detail(@PathVariable("id") Integer id) {
        return this.boardService.getBoard(id);
    }

    @GetMapping("/api/board/create")
    public String boardCreate(){
        return "board_form";
    }

    @PostMapping("/api/board/create")
    @ResponseBody  //여기도 responsebody가 있어야 포스트맨에서 500 에러가 안남..왜지
    public void boardCreate(@RequestBody BoardRequestDto boardRequestDto) {
        String tempTitle=boardRequestDto.getTitle();
        String tempContent=boardRequestDto.getContent();
        // 질문을 저장
        this.boardService.createNewBoard(tempTitle,tempContent);
    }


    @GetMapping("/api/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id) {
        return "board_form";
    }


    @PatchMapping("/api/board/update/{id}")
    public void boardUpdate(@PathVariable("id") Integer id, @RequestBody BoardRequestDto boardRequestDto) {
        this.boardService.updateBoard(id,boardRequestDto);
    }

    /// ?????질문!!!!! 컨트롤러에서 각 메소드의 리턴값 DTO로 해야하는건지 질문하기



}
