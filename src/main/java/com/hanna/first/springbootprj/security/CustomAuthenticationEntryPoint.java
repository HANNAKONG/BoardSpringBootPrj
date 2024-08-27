package com.hanna.first.springbootprj.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanna.first.springbootprj.security.dto.ErrorResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    // 자바 객체를 JSON으로 직렬화하거나 JSON을 자바 객체로 역직렬화할 때 사용 (Jackson 라이브러리에서 제공)
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex) throws IOException, ServletException {
        System.out.println("================Authentication failed: " + ex.getMessage());

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //401 Unauthorized
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMsg("사용자 인증에 실패하였습니다.");

        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
