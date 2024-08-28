package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.board.Board;
import com.hanna.first.springbootprj.domain.board.BoardType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BoardRequestDto {

    private Long id;

    @NotNull
    private BoardType boardTypeCode;

    @NotBlank
    private String boardName;

    /**********************************
     *  constructor
     **********************************/
    public BoardRequestDto() {
    }

    public BoardRequestDto(Long id, BoardType boardTypeCode, String boardName) {
        this.id = id;
        this.boardTypeCode = boardTypeCode;
        this.boardName = boardName;
    }

    /**********************************
     *  toEntity
     **********************************/
    public Board toEntity(){
        return Board.builder()
                .boardTypeCode(boardTypeCode)
                .boardName(boardName)
                .build();
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

    /**********************************
     *  builder
     **********************************/
    public static class Builder {
        private Long id;
        private BoardType boardTypeCode;
        private String boardName;

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

        public BoardRequestDto build() {
            return new BoardRequestDto(id, boardTypeCode, boardName);
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}
