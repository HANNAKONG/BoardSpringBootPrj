package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.user.User;
import com.hanna.first.springbootprj.domain.user.UserRole;

public class UserRequestDto {

    private Long id;
    private String userId;
    private String password;
    private String userName;
    private UserRole userRole;

    /**********************************
     *  생성자
     **********************************/
    public UserRequestDto() {
    }

    public UserRequestDto(Long id, String userId, String password, String userName, UserRole userRole) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.userRole = userRole;
    }

    /**********************************
     *  toEntity
     **********************************/
    public User toEntity(){
        return User.builder()
                .userId(userId)
                .password(password)
                .userName(userName)
                .userRole(userRole)
                .build();
    }

    /**********************************
     *  getter
     **********************************/
    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    //임시 setter
    public void setPassword(String password) {
        this.password = password;
    }

    /**********************************
     *  builder
     **********************************/
    public static class Builder {
        private Long id;
        private String userId;
        private String password;
        private String userName;
        private UserRole userRole;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder userRole(UserRole userRole) {
            this.userRole = userRole;
            return this;
        }

        public UserRequestDto build() {
            return new UserRequestDto(id, userId, password, userName, userRole);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

}
