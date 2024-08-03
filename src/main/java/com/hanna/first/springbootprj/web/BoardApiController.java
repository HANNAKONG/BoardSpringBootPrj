package com.hanna.first.springbootprj.web;

import com.hanna.first.springbootprj.service.BoardService;
import com.hanna.first.springbootprj.web.dto.BoardRequestDto;
import com.hanna.first.springbootprj.web.dto.BoardResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardApiController {

    private final BoardService boardService;

    public BoardApiController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**********************************
     *  1. 게시글 목록 조회
     **********************************/
    @GetMapping("/api/v1/board")
    public List<BoardResponseDto> getBoardList(@RequestBody BoardRequestDto requestDto){
        return boardService.getBoardList(requestDto);
    }

}
