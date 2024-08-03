package com.hanna.first.springbootprj.domain.post;

public enum PostStatus {
    DRAFT,
    PUBLISHED;

    public String getPostStatus() {
        return name();
    }
}
