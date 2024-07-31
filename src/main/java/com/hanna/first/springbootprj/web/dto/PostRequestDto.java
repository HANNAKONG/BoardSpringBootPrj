package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.post.Post;

public class PostRequestDto {

    private Long id;
    private String boardTypeCode;
    private String postStatusCode;
    private String title;
    private String content;
    private String authorId;

    /**********************************
     *  getter
     **********************************/
    public Long getId() {
        return id;
    }

    public String getBoardTypeCode() {
        return boardTypeCode;
    }

    public String getPostStatusCode() {
        return postStatusCode;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorId() {
        return authorId;
    }

    /**********************************
     *  builder
     **********************************/
    public static class Builder {
        private Long id;
        private String boardTypeCode;
        private String postStatusCode;
        private String title;
        private String content;
        private String authorId;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder boardTypeCode(String boardTypeCode) {
            this.boardTypeCode = boardTypeCode;
            return this;
        }

        public Builder postStatusCode(String postStatusCode) {
            this.postStatusCode = postStatusCode;
            return this;
        }


        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder authorId(String authorId) {
            this.authorId = authorId;
            return this;
        }

        public PostRequestDto build() {
            return new PostRequestDto(id, boardTypeCode, postStatusCode, title, content, authorId);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    /**********************************
     *  constructor
     **********************************/
    public PostRequestDto(Long id, String boardTypeCode, String postStatusCode, String title, String content, String authorId) {
        this.id = id;
        this.boardTypeCode = boardTypeCode;
        this.postStatusCode = postStatusCode;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    /**********************************
     *  toEntity
     **********************************/
    public Post toEntity(){
        return Post.builder()
                .boardTypeCode(boardTypeCode)
                .postStatusCode(postStatusCode)
                .title(title)
                .content(content)
                .authorId(authorId)
                .build();
    }


}
