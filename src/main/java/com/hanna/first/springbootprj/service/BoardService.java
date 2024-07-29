package com.hanna.first.springbootprj.service;

import com.hanna.first.springbootprj.web.dto.BoardRequestDto;
import com.hanna.first.springbootprj.web.dto.BoardResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface BoardService {
    // 1. 게시글 목록(게시판) 조회
    List<BoardResponseDto> getBoardList(BoardRequestDto requestDto);

    // 2. 게시글 조회
    BoardResponseDto getPost(Long id);

    // 3. 게시글 등록
    BoardResponseDto savePost(BoardRequestDto requestDto);

    // 4. 게시글 수정
    BoardResponseDto updatePost(Long id, BoardRequestDto requestDto);

    // 5. 게시글 삭제
    BoardResponseDto deletePost(Long id, BoardRequestDto requestDto);
}
