package com.hanna.first.springbootprj.domain.post;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hanna.first.springbootprj.domain.BaseTime;
import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.user.User;
import javax.persistence.*;

@Entity
public class Post extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PostStatus postStatusCode;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    @JsonBackReference
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**********************************
     *  기본 생성자
     **********************************/
    protected Post() {}

    /**********************************
     *  생성자
     **********************************/
    public Post(Long id, PostStatus postStatusCode, String title, String content, Board board, User user) {
        this.id = id;
        this.postStatusCode = postStatusCode;
        this.title = title;
        this.content = content;
        this.board = board;
        this.user = user;
    }

    /**********************************
     *  update method
     **********************************/
    public void update(PostStatus postStatusCode, String title, String content){
        if(postStatusCode != null){
            this.postStatusCode = postStatusCode;
        }
        if(title != null){
            this.title = title;
        }
        if(content != null){
            this.content = content;
        }
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

    public Board getBoard() {
        return board;
    }

    public User getUser() {
        return user;
    }

    /**********************************
     *  builder
     **********************************/
    public static class Builder {
        private Long id;
        private PostStatus postStatusCode;
        private String title;
        private String content;
        private Board board;
        private User user;

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

        public Builder board(Board board) {
            this.board = board;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Post build() {
            Post post = new Post(id, postStatusCode, title, content, board, user);

            // 연관관계 편의 메서드를 빌더에서 수행
            if (board != null) {
                board.getPostList().add(post);
            }
            if (user != null) {
                user.getPostList().add(post);
            }

            return post;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

}
