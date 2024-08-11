package com.hanna.first.springbootprj.service;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.board.BoardRepository;
import com.hanna.first.springbootprj.domain.post.Post;
import com.hanna.first.springbootprj.web.dto.BoardRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(final BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /**********************************
     *  1. 게시판 등록
     **********************************/
    @Transactional
    public void saveBoard(final BoardRequestDto requestDto){
        final Board entityDto = requestDto.toEntity();
        boardRepository.save(entityDto);
    }

    /**********************************
     *  2. 게시판 정보 수정
     **********************************/
    @Transactional
    public void updateBoardInfo(final Long id, final BoardRequestDto requestDto){
        final Board entity = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시판이 없습니다. id"+ id)
        );

        entity.update(requestDto.getBoardTypeCode(), requestDto.getBoardName());

    }

    /**********************************
     *  3. 게시판 삭제
     **********************************/
    @Transactional
    public void deleteBoard(final Long id, final BoardRequestDto requestDto){
        final Board entity = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시판이 없습니다. id"+ id)
        );

        boardRepository.delete(entity);
    }


}
