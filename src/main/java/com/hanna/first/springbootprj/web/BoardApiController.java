package com.hanna.first.springbootprj.web;

import com.hanna.first.springbootprj.service.BoardService;
import com.hanna.first.springbootprj.web.dto.BoardRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {

    private final BoardService boardService;

    public BoardApiController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 유저 권한: ADMIN인 경우 게시판 등록, 정보 변경, 삭제 가능
    /**********************************
     *  1. 게시판 등록
     **********************************/
    @PostMapping("/api/v1/board")
    public void saveBoard(@RequestBody BoardRequestDto requestDto){
        boardService.saveBoard(requestDto);
    }

    /**********************************
     *  2. 게시판 정보 수정
     **********************************/
    @PutMapping("/api/v1/boardinfo/{id}")
    public void updateBoardInfo(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        boardService.updateBoardInfo(id, requestDto);
    }

    /**********************************
     *  3. 게시글 삭제
     **********************************/
    @DeleteMapping("/api/v1/board/{id}")
    public void deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        boardService.deleteBoard(id, requestDto);
    }

}
