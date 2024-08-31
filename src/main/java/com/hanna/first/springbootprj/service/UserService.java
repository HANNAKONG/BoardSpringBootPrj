package com.hanna.first.springbootprj.service;

import com.hanna.first.springbootprj.security.JwtTokenProvider;
import com.hanna.first.springbootprj.domain.user.User;
import com.hanna.first.springbootprj.domain.user.UserRepository;
import com.hanna.first.springbootprj.domain.user.UserRole;
import com.hanna.first.springbootprj.web.dto.UserRequestDto;
import com.hanna.first.springbootprj.web.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserService(final UserRepository userRepository, final PasswordEncoder passwordEncoder, final JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /**********************************
     *  1. 회원정보 조회
     **********************************/
    public UserResponseDto getUserInfo(final String userId){
        final User entity = userRepository.findByUserId(userId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 회원입니다. 아이디: "+ userId)
        );

        return new UserResponseDto(entity);
    }

    /**********************************
     *  2. 회원 가입
     **********************************/
    @Transactional
    public void signup(final UserRequestDto requestDto){
        //중복여부 check
        userRepository.findByUserId(requestDto.getUserId()).ifPresent((final User user) -> {
            throw new IllegalArgumentException("이미 가입한 회원입니다. 아이디: " + requestDto.getUserId());
        });

        //비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        System.out.println("서비스 비밀번호 암호화=====>" +encodedPassword);

        requestDto.setPassword(encodedPassword);
        final User entityDto = requestDto.toEntity();
        userRepository.save(entityDto);
    }

    /**********************************
     *  3. 회원정보 수정
     **********************************/
    @Transactional
    public void updateUserInfo(final String userId, final UserRequestDto requestDto){
        final User entity = userRepository.findByUserId(userId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 회원입니다. 아이디: "+ userId)
        );

        //비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        System.out.println("서비스 비밀번호 암호화=====>" +encodedPassword);

        entity.update(encodedPassword, requestDto.getUserName(), requestDto.getUserRole());
    }

    /**********************************
     *  4. 회원 탈퇴
     **********************************/
    @Transactional
    public void deleteUserInfo(final String userId){
        final User entity = userRepository.findByUserId(userId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 회원입니다. 아이디: "+ userId)
        );

        userRepository.delete(entity);
    }

    /**********************************
     *  5. 로그인
     **********************************/
    @Transactional
    public String login(final UserRequestDto requestDto){
        final User entity = userRepository.findByUserId(requestDto.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 회원입니다. 아이디: "+ requestDto.getUserId())
        );

        if (!passwordEncoder.matches(requestDto.getPassword(), entity.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        String token = jwtTokenProvider.createToken(entity.getUserId());

        return token;
    }

}
