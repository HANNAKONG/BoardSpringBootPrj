package com.hanna.first.springbootprj.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanna.first.springbootprj.config.auth.dto.EntryPointErrorResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex) throws IOException, ServletException {
        ObjectMapper objectMapper = new ObjectMapper(); // 자바 객체를 JSON으로 직렬화하거나 JSON을 자바 객체로 역직렬화할 때 사용 (Jackson 라이브러리에서 제공)
        EntryPointErrorResponse entryPointErrorResponse = new EntryPointErrorResponse();
        entryPointErrorResponse.setMsg("인증이 실패하였습니다.");

        System.out.println("================Authentication failed: " + ex.getMessage());
        response.setStatus(401);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(entryPointErrorResponse));

    }
}
