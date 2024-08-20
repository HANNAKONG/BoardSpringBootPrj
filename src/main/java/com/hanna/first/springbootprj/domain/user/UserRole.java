package com.hanna.first.springbootprj.domain.user;

public enum UserRole {
    ADMIN,
    USER;

    public String getUserRole() {
        return name();
    }
}
