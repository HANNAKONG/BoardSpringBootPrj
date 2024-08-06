package com.hanna.first.springbootprj.service;

import com.hanna.first.springbootprj.domain.post.Post;
import com.hanna.first.springbootprj.domain.user.User;
import com.hanna.first.springbootprj.domain.user.UserRepository;
import com.hanna.first.springbootprj.domain.user.UserRole;
import com.hanna.first.springbootprj.web.dto.UserRequestDto;
import com.hanna.first.springbootprj.web.dto.UserResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**********************************
     *  1. 회원정보 조회
     **********************************/
    public UserResponseDto getUserInfo(final UserRequestDto requestDto){
        final User entity = userRepository.findByUserId(requestDto.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("해당 회원이 없습니다. userId"+ requestDto.getUserId())
        );

        return new UserResponseDto(entity);
    }

    /**********************************
     *  2. 회원 가입
     **********************************/
    @Transactional
    public void signup(final UserRequestDto requestDto){
        //중복여부 check
        userRepository.findByUserId(requestDto.getUserId()).ifPresent(user -> {
            throw new IllegalArgumentException("이미 가입된 회원입니다. userId: " + requestDto.getUserId());
        });

        final User entityDto = requestDto.toEntity();
        userRepository.save(entityDto);
    }

    /**********************************
     *  3. 회원정보 수정
     **********************************/
    @Transactional
    public void updateUserInfo(final UserRequestDto requestDto){
        final User entity = userRepository.findByUserId(requestDto.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("해당 회원이 없습니다. userId"+ requestDto.getUserId())
        );

        entity.update(requestDto.getPassword(), requestDto.getUserName(), requestDto.getUserRole());
    }

    /**********************************
     *  4. 회원 탈퇴
     **********************************/
    @Transactional
    public void deleteUserInfo(final UserRequestDto requestDto){
        final User entity = userRepository.findByUserId(requestDto.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("해당 회원이 없습니다. userId"+ requestDto.getUserId())
        );

        userRepository.delete(entity);
    }

}
