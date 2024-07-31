package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.board.BoardType;
import com.hanna.first.springbootprj.domain.post.Post;
import com.hanna.first.springbootprj.domain.post.PostStatus;

public class PostRequestDto {

    private Long id;
    private BoardType boardTypeCode;
    private PostStatus postStatusCode;
    private String title;
    private String content;
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
        private BoardType boardTypeCode;
        private PostStatus postStatusCode;
        private String title;
        private String content;
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
    public PostRequestDto(Long id, BoardType boardTypeCode, PostStatus postStatusCode, String title, String content, String authorId) {
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
