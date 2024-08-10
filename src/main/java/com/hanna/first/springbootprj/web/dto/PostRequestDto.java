package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.post.Post;
import com.hanna.first.springbootprj.domain.post.PostStatus;
import com.hanna.first.springbootprj.domain.user.User;

public class PostRequestDto {

    private Long id;
    private PostStatus postStatusCode;
    private String title;
    private String content;
    private Long boardId;
    private Long userId;

    /**********************************
     *  constructor
     **********************************/
    public PostRequestDto() {
    }

    public PostRequestDto(Long id, PostStatus postStatusCode, String title, String content, Long boardId, Long userId) {
        this.id = id;
        this.postStatusCode = postStatusCode;
        this.title = title;
        this.content = content;
        this.boardId = boardId;
        this.userId = userId;
    }

    /**********************************
     *  toEntity
     **********************************/
    public Post toEntity(Board board, User user){
        return Post.builder()
                .postStatusCode(postStatusCode)
                .title(title)
                .content(content)
                .board(board)
                .user(user)
                .build();
    }

    /**********************************
     *  getter
     **********************************/
    public Long getId() {
        return id;
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

    public Long getBoardId() {
        return boardId;
    }

    public Long getUserId() {
        return userId;
    }

    /**********************************
     *  builder
     **********************************/
    public static class Builder {
        private Long id;
        private PostStatus postStatusCode;
        private String title;
        private String content;
        private Long boardId;
        private Long userId;

        public Builder id(Long id) {
            this.id = id;
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

        public Builder boardId(Long boardId) {
            this.boardId = boardId;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public PostRequestDto build() {
            return new PostRequestDto(id, postStatusCode, title, content, boardId, userId);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

}
