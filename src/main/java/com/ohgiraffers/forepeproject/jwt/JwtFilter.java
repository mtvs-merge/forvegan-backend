package com.ohgiraffers.forepeproject.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import com.ohgiraffers.forepeproject.exception.ApiExceptionDTO;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class JwtFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION_HEADER = "Auth";
    public static final String BEARER_PREFIX = "bearer";
    private static final Logger log = LoggerFactory.getLogger(OncePerRequestFilter.class);
    private final TokenProvider tokenProvider;

    private final RequestMatcher requestMatcher = new AntPathRequestMatcher("/api/v1/login/**");

    public JwtFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            // 1. Request Header 토큰 꺼내기
            String jwtHeader = resolveToken(request);
            log.info("[JwtFilter] jwtHeader : {}", jwtHeader);

            // 2. validateToken 으로 토큰 유효성 검사
            // 정상 토큰이면 해당 토큰으로 Authentication 을 가져와서 SecurityContext에 저장
            if (StringUtils.hasText(jwtHeader) && tokenProvider.validateToken(jwtHeader)) {
                Authentication authentication = tokenProvider.getAuthentication(jwtHeader);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);

        } catch (RuntimeException e) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            ApiExceptionDTO errorResponse = new ApiExceptionDTO(HttpStatus.UNAUTHORIZED, e.getMessage());

            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write(convertObjectToJson(errorResponse));
        }
    }

    private String resolveToken(HttpServletRequest request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);

        Map<String, String> tokenToMap = objectMapper.readValue(bearerToken, Map.class);

        if(StringUtils.hasText(tokenToMap.get("accessToken")) && (tokenToMap.get("grantType").equals(BEARER_PREFIX))) {
            return tokenToMap.get("accessToken");
        }

        return null;
    }

    private String convertObjectToJson(Object object) throws JsonProcessingException {
        if(object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        if("/api/v1/login/kakaoCode".equals(path)) {
            return true;
        } else if("/api/v1/login/renew".equals(path)) {
            return true;
        } else {
            return false;
        }
    }
}
