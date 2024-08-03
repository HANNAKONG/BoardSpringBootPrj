package com.hanna.first.springbootprj.domain.board;

import com.hanna.first.springbootprj.domain.post.Post;
import com.hanna.first.springbootprj.domain.post.PostStatus;

import javax.persistence.*;
import java.util.List;

@Entity
public class Board {
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

    @Column(nullable = false)
    private String authorId;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> postList;

    /**********************************
     *  기본 생성자
     **********************************/
    protected Board() {}

    /**********************************
     *  생성자
     **********************************/
    public Board(Long id, BoardType boardTypeCode, PostStatus postStatusCode, String title, String authorId) {
        this.id = id;
        this.boardTypeCode = boardTypeCode;
        this.postStatusCode = postStatusCode;
        this.title = title;
        this.authorId = authorId;
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

    public String getAuthorId() {
        return authorId;
    }

    public List<Post> getPostList() {
        return postList;
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

        public Board build() {
            return new Board(id, boardTypeCode, postStatusCode, title, authorId);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

}
