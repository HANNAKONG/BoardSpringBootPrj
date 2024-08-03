package com.hanna.first.springbootprj.domain.board;

public enum BoardType {
    NOTICE,
    HUMOR,
    FREE,
    ANONYMOUS;

    public String getBoardType() {
        return name();
    }
}
