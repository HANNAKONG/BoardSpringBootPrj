package com.hanna.first.springbootprj.domain.post;

public enum PostStatus {
    DRAFT("01"),
    PUBLISHED("02");

    private final String code;

    PostStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
