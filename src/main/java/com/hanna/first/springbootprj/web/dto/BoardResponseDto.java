package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.board.BoardType;
import com.hanna.first.springbootprj.domain.post.Post;

import java.util.List;

public class BoardResponseDto {

    private Long id;
    private BoardType boardTypeCode;
    private String boardName;

    /**********************************
     *  constructor (entity to dto)
     **********************************/
    public BoardResponseDto(Board entity){
        this.id = entity.getId();
        this.boardTypeCode = entity.getBoardTypeCode();
        this.boardName = entity.getBoardName();
    }

    /**********************************
     *  getter
     **********************************/
    public Long getId() {
        return id;
    }

    public BoardType getBoardTypeCode() {
        return boardTypeCode;
    }

    public String getBoardName() {
        return boardName;
    }
}
