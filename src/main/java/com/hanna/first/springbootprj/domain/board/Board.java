package com.hanna.first.springbootprj.domain.board;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hanna.first.springbootprj.domain.post.Post;

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

    @Column(length = 500, nullable = false)
    private String boardName;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Post> postList;

    /**********************************
     *  기본 생성자
     **********************************/
    protected Board() {}

    /**********************************
     *  생성자
     **********************************/
    public Board(Long id, BoardType boardTypeCode, String boardName) {
        this.id = id;
        this.boardTypeCode = boardTypeCode;
        this.boardName = boardName;
    }

    /**********************************
     *  update method
     **********************************/
    public void update(BoardType boardTypeCode, String boardName){
        if(boardTypeCode != null){
            this.boardTypeCode = boardTypeCode;
        }
        if(boardName != null){
            this.boardName = boardName;
        }
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

    public List<Post> getPostList() {
        return postList;
    }

    /**********************************
     *  builder
     **********************************/
    public static class Builder {
        private Long id;
        private BoardType boardTypeCode;
        private String boardName;
        private List<Post> postList;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder boardTypeCode(BoardType boardTypeCode) {
            this.boardTypeCode = boardTypeCode;
            return this;
        }

        public Builder boardName(String boardName) {
            this.boardName = boardName;
            return this;
        }


        public Board build() {
            return new Board(id, boardTypeCode, boardName);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

}
