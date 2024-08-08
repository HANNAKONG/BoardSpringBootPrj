package com.hanna.first.springbootprj.web;

import com.hanna.first.springbootprj.domain.board.BoardType;
import com.hanna.first.springbootprj.domain.post.PostStatus;
import com.hanna.first.springbootprj.service.BoardService;
import com.hanna.first.springbootprj.web.dto.BoardRequestDto;
import com.hanna.first.springbootprj.web.dto.BoardResponseDto;
import com.hanna.first.springbootprj.web.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardApiController {

    private final BoardService boardService;

    public BoardApiController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 회원권한-ADMIN인 경우 게시판 등록, 삭제, 이름변경 등 가능하게 추가?
    /**********************************
     *  게시판 등록
     **********************************/
    @PostMapping("/api/v1/board")
    public void saveBoard(@RequestBody BoardRequestDto requestDto){
        boardService.saveBoard(requestDto);
    }

}
