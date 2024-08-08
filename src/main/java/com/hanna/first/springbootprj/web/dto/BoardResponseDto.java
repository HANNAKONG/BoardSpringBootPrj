package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.board.BoardType;
import com.hanna.first.springbootprj.domain.post.Post;

import java.util.List;

public class BoardResponseDto {

    private Long id;
    private BoardType boardTypeCode;
    private String boardName;
    private List<Post> postList;

    /**********************************
     *  constructor (entity to dto)
     **********************************/
    public BoardResponseDto(Board entity){
        this.id = entity.getId();
        this.boardTypeCode = entity.getBoardTypeCode();
        this.boardName = entity.getBoardName();
        this.postList = entity.getPostList();
    }

    /**********************************
     *  getter
     **********************************/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BoardType getBoardTypeCode() {
        return boardTypeCode;
    }

    public void setBoardTypeCode(BoardType boardTypeCode) {
        this.boardTypeCode = boardTypeCode;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
