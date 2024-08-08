package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.post.Post;
import com.hanna.first.springbootprj.domain.post.PostStatus;
import com.hanna.first.springbootprj.domain.user.User;
import com.hanna.first.springbootprj.domain.user.UserRole;

public class UserResponseDto {

    private Long id;
    private String userId;
    private String password;
    private String userName;
    private UserRole userRole;

    /**********************************
     *  constructor (entity to dto)
     **********************************/
    public UserResponseDto(User entity){
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.password = entity.getPassword();
        this.userName = entity.getUserName();
        this.userRole = entity.getUserRole();
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
}
