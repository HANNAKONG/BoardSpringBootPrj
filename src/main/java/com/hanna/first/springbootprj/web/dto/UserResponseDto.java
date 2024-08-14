package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.user.User;
import com.hanna.first.springbootprj.domain.user.UserRole;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserResponseDto {

    private Long id;
    private String userId;
    private String password;
    private String userName;
    private UserRole userRole;
    private LocalDateTime createdDate;

    /**********************************
     *  constructor (entity to dto)
     **********************************/
    public UserResponseDto(User entity){
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.password = entity.getPassword();
        this.userName = entity.getUserName();
        this.userRole = entity.getUserRole();
        this.createdDate = entity.getCreatedDate();
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

    public String getCreatedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return createdDate.format(formatter);
    }

}
