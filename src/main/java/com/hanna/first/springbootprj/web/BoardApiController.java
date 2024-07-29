package com.hanna.first.springbootprj.web;

import com.hanna.first.springbootprj.service.BoardService;
import com.hanna.first.springbootprj.web.dto.BoardRequestDto;
import com.hanna.first.springbootprj.web.dto.BoardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardApiController {

    private final BoardService boardService;

    @Autowired
    public BoardApiController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 1. 게시글 목록(게시판) 조회
    @GetMapping("/api/v1/posts")
    public List<BoardResponseDto> getBoardList(@RequestBody BoardRequestDto requestDto){
        return boardService.getBoardList(requestDto);
    }

    // 2. 게시글 조회
    @GetMapping("/api/v1/posts/{id}")
    public BoardResponseDto getPost(@PathVariable Long id){
        return boardService.getPost(id);
    }

    // 3. 게시글 등록
    @PostMapping("/api/v1/posts")
    public BoardResponseDto savePost(@RequestBody BoardRequestDto requestDto){
        return boardService.savePost(requestDto);
    }

    // 4. 게시글 수정
    @PutMapping("/api/v1/posts/{id}")
    public BoardResponseDto updatePost(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        return boardService.updatePost(id, requestDto);
    }
    
    // 5. 게시글 삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public BoardResponseDto deletePost(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        return boardService.deletePost(id, requestDto);
    }


}
