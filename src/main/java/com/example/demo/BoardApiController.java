package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping("/api/board/list")
    //@ResponseBody  //컨트롤러 어노테이션을 @COntroller로 썼을 때에는 @ResponseBody가 필요하지만, @restController 쓰면 필요 없다. 자동으로 같은 역할 수행해줌.
    public List<BoardResponseDto> list() {
        return this.boardService.getBoardDtoList();  //json 형태로 값만 반환
    }

    @GetMapping(value="api/board/detail/{id}")
    //@ResponseBody
    public BoardResponseDto detail(@PathVariable("id") Integer id) {
        return this.boardService.getBoard(id);
    }

    @GetMapping("/api/board/create")
    public String boardCreate(){
        return "board_form";
    }

    @PostMapping("/api/board/create")
    //@ResponseBody  //여기도 responsebody가 있어야 포스트맨에서 500 에러가 안남..왜지  --> @Controller 어노테이션은 기본적으로 html 파일의 이름을 리턴값으로 받기를 기대하는데, 내가 지금 void로 메소드 만듦.
    //@ResponseBody 어노테이션을 붙이면 "메소드의 결과가 html 파일 이름이 아니고, 값을 직접 HTTP response body로 보내겠다"고 스프링에 알려주는 셈이므로 @ResponseBody 붙여야 에러 안 남.

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


    @DeleteMapping("/api/board/delete/{id}")
    public void boardDelete(@PathVariable("id") Integer id) {
        this.boardService.deleteBoard(id);
    }

}
