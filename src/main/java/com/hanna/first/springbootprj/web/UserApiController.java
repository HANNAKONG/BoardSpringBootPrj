package com.hanna.first.springbootprj.web;

import com.hanna.first.springbootprj.service.UserService;
import com.hanna.first.springbootprj.validation.group.Create;
import com.hanna.first.springbootprj.validation.group.Update;
import com.hanna.first.springbootprj.web.dto.UserRequestDto;
import com.hanna.first.springbootprj.web.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    /**********************************
     *  1. 회원정보 조회
     **********************************/
    @GetMapping("/api/v1/users/{userId}")
    public UserResponseDto getUserInfo(@PathVariable("userId") String userId){
        return userService.getUserInfo(userId);
    }

    /**********************************
     *  2. 회원 가입
     **********************************/
    @PostMapping("/api/v1/users")
    public void signup(@Validated(Create.class) @RequestBody UserRequestDto requestDto){
        userService.signup(requestDto);
    }

    /**********************************
     *  3. 회원정보 수정
     **********************************/
    @PatchMapping("/api/v1/users/{userId}")
    public void updateUserInfo(@PathVariable("userId") String userId, @Validated(Update.class) @RequestBody UserRequestDto requestDto){
        userService.updateUserInfo(userId, requestDto);
    }

    /**********************************
     *  4. 회원 탈퇴
     **********************************/
    @DeleteMapping("/api/v1/users/{userId}")
    public void deleteUserInfo(@PathVariable("userId") String userId){
        userService.deleteUserInfo(userId);
    }

    /**********************************
     *  5. 로그인
     **********************************/
    @PostMapping("/api/v1/users/login")
    public ResponseEntity<Void> login(@Validated @RequestBody UserRequestDto requestDto, HttpServletResponse response){
        return userService.login(requestDto, response);
    }
    
}
