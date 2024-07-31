package com.hanna.first.springbootprj.domain.board;

public enum BoardType {
    NOTICE("01"),
    HUMOR("02"),
    FREE("03"),
    ANONYMOUS("04");

    private final String code;

    BoardType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
