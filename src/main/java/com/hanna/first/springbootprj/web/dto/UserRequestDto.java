package com.hanna.first.springbootprj.web.dto;

import com.hanna.first.springbootprj.domain.user.User;
import com.hanna.first.springbootprj.domain.user.UserRole;
import com.hanna.first.springbootprj.validation.group.Create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRequestDto {

    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9]{4,}$", message = "아이디는 4~10자리 영문과 숫자로 구성되어야 합니다.")
    private String userId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9~!@#$%^&*()_+=?,./<>{}\\[\\]\\-]{8,15}$", message = "비밀번호는 8~15자리 영문, 숫자, 특수문자로 구성되어야 합니다.")
    private String password;

    @NotBlank(message = "사용자 이름은 필수입니다.", groups = Create.class)
    @Size(min = 1, max = 50, message = "사용자 이름은 1자 이상 50자 이하로 입력해야 합니다.")
    private String userName;

    @NotNull(groups = Create.class)
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
