package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.post.Post;

public class PostResponseDto {

    private Long id;
    private String boardTypeCode;
    private String postStatusCode;
    private String title;
    private String content;
    private String authorId;

    /**********************************
     *  constructor (entity to dto)
     **********************************/
    public PostResponseDto(Post entity){
        this.id = entity.getId();
        this.boardTypeCode = entity.getBoardTypeCode();
        this.postStatusCode = entity.getPostStatusCode();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.authorId = entity.getAuthorId();
    }
}
