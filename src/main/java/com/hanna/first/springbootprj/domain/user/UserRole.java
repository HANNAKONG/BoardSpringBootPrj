package com.hanna.first.springbootprj.domain.user;

public enum UserRole {
    ROLE_ADMIN,
    ROLE_USER;

    public String getUserRole() {
        return name();
    }
}
