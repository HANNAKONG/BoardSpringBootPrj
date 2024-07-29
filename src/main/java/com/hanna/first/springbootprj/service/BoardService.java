package com.hanna.first.springbootprj.service;

import com.hanna.first.springbootprj.web.dto.BoardRequestDto;
import com.hanna.first.springbootprj.web.dto.BoardResponseDto;
import com.hanna.first.springbootprj.web.dto.PostRequestDto;
import com.hanna.first.springbootprj.web.dto.PostResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface BoardService {
    // 1. 게시글 목록(게시판) 조회
    List<BoardResponseDto> getBoardList(BoardRequestDto requestDto);

    // 2. 게시글 조회
    PostResponseDto getPost(Long id);

    // 3. 게시글 등록
    PostResponseDto savePost(PostRequestDto requestDto);

    // 4. 게시글 수정
    PostResponseDto updatePost(Long id, PostRequestDto requestDto);

    // 5. 게시글 삭제
    PostResponseDto deletePost(Long id, PostRequestDto requestDto);
}
