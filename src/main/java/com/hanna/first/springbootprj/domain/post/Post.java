package com.hanna.first.springbootprj.domain.post;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.board.BoardType;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BoardType boardTypeCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PostStatus postStatusCode;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String authorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    /**********************************
     *  기본 생성자
     **********************************/
    protected Post() {}

    /**********************************
     *  생성자
     **********************************/
    public Post(Long id, BoardType boardTypeCode, PostStatus postStatusCode, String title, String content, String authorId) {
        this.id = id;
        this.boardTypeCode = boardTypeCode;
        this.postStatusCode = postStatusCode;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    /**********************************
     *  update method
     **********************************/
    public void update(PostStatus postStatusCode, String title, String content){
        this.postStatusCode = postStatusCode;
        this.title = title;
        this.content = content;
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

    public Board getBoard() {
        return board;
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

        public Post build() {
            return new Post(id, boardTypeCode, postStatusCode, title, content, authorId);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

}
