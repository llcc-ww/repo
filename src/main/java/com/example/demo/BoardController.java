package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor //final이 붙은 필드들의 생성자를 자동으로 만들어주는 롬복 어노테이션.
@Controller
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/board/list")
    public String list(Model model) {
        List<BoardResponseDto> boardList = this.boardService.getBoardDtoList();
        //List<Board> boardList = this.boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "board_list";
    }

    @GetMapping(value="/board/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        BoardResponseDto board = this.boardService.getBoard(id);
        model.addAttribute("board", board);
        return "board_detail";
    }

    @GetMapping("/board/create")
    public String boardCreate(){
        return "board_form";
    }

    @PostMapping("/board/create")

    public String questionCreate(@RequestParam(value="title") String title, @RequestParam(value="content") String content) {
        // 질문을 저장
        this.boardService.createNewBoard(title,content);
        return "redirect:/board/list"; // 질문 저장후 질문목록으로 이동
    }

}
