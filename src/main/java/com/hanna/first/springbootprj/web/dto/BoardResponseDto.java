package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.board.BoardType;
import com.hanna.first.springbootprj.domain.post.PostStatus;

public class BoardResponseDto {

    private Long id;
    private BoardType boardTypeCode;
    private PostStatus postStatusCode;
    private String title;
    private String authorId;

    /**********************************
     *  constructor (entity to dto)
     **********************************/
    public BoardResponseDto(Board entity){
        this.id = entity.getId();
        this.boardTypeCode = entity.getBoardTypeCode();
        this.postStatusCode = entity.getPostStatusCode();
        this.title = entity.getTitle();
        this.authorId = entity.getAuthorId();
    }
}
