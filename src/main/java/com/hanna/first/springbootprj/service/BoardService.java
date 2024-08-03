package com.hanna.first.springbootprj.service;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.board.BoardRepository;
import com.hanna.first.springbootprj.domain.post.PostStatus;
import com.hanna.first.springbootprj.web.dto.BoardRequestDto;
import com.hanna.first.springbootprj.web.dto.BoardResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    
    /**********************************
     *  1. 게시글 목록 조회
     **********************************/
    @Transactional(readOnly = true)
    public List<BoardResponseDto> getBoardList(BoardRequestDto requestDto){

        //게시글 상태 = 게시인 글만 조회
        BoardRequestDto requestDtoSet = BoardRequestDto.builder()
                .boardTypeCode(requestDto.getBoardTypeCode())
                .postStatusCode(PostStatus.PUBLISHED)
                .title(requestDto.getTitle())
                .authorId(requestDto.getAuthorId())
                .build();

        //List<Board> boardList = boardRepository.findAllByBoardTypeCodeAndPostStatusCode(requestDtoSet);
        List<Board> boardList = boardRepository.findAll();
        return boardList.stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

}
