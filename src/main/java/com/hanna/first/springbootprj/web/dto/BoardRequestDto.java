package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.board.BoardType;
import com.hanna.first.springbootprj.domain.post.PostStatus;

public class BoardRequestDto {

    private Long id;
    private BoardType boardTypeCode;
    private PostStatus postStatusCode;
    private String title;
    private String authorId;

    /**********************************
     *  getter
     **********************************/
    public Long getId() {
        return id;
    }

    public BoardType getBoardTypeCode() {
        return boardTypeCode;
    }

    public PostStatus getPostStatusCode() {
        return postStatusCode;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorId() {
        return authorId;
    }

    /**********************************
     *  builder
     **********************************/
    public static class Builder {
        private Long id;
        private BoardType boardTypeCode;
        private PostStatus postStatusCode;
        private String title;
        private String authorId;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder boardTypeCode(BoardType boardTypeCode) {
            this.boardTypeCode = boardTypeCode;
            return this;
        }

        public Builder postStatusCode(PostStatus postStatusCode) {
            this.postStatusCode = postStatusCode;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder authorId(String authorId) {
            this.authorId = authorId;
            return this;
        }

        public BoardRequestDto build() {
            return new BoardRequestDto(id, boardTypeCode, postStatusCode, title, authorId);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    /**********************************
     *  constructor
     **********************************/
    public BoardRequestDto(Long id, BoardType boardTypeCode, PostStatus postStatusCode, String title, String authorId) {
        this.id = id;
        this.boardTypeCode = boardTypeCode;
        this.postStatusCode = postStatusCode;
        this.title = title;
        this.authorId = authorId;
    }

    /**********************************
     *  toEntity
     **********************************/
    public Board toEntity(){
        return Board.builder()
                .boardTypeCode(boardTypeCode)
                .postStatusCode(postStatusCode)
                .title(title)
                .authorId(authorId)
                .build();
    }
}
