package com.example.springboot18.filter;

import cn.hutool.core.util.StrUtil;
import com.example.springboot18.util.JWTUtil;
import com.example.springboot18.view.ResultView;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/*")
public class MyFilter implements Filter {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 定义不需要拦截的地址
     */
    private static String directUrls[] = {
            "/swagger-ui/**",
            "/swagger-resources/**",
            "/v3/api-docs",
            "/v2/api-docs",
            "/webjars/**",
            "/doc.html",
    };

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String path = httpServletRequest.getServletPath();

        // 实现通配符的作用
        boolean sign = Arrays.stream(directUrls).anyMatch(s -> antPathMatcher.match(s, path));

        if (sign) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        System.out.println("开始登录校验");
        String token = httpServletRequest.getHeader("Authorization");
        if (StrUtil.isEmpty(token)) {
            ObjectMapper objectMapper = new ObjectMapper();
            servletResponse.getWriter().write(objectMapper.writeValueAsString(ResultView.fail()));
            return;
        }

        String userId = "";
        // 解析token
        try {
            userId = JWTUtil.getClaim("userId", token);
        } catch (Exception e) {
            e.printStackTrace();
            ObjectMapper objectMapper = new ObjectMapper();
            servletResponse.getWriter().write(objectMapper.writeValueAsString(ResultView.fail()));
            return;
        }

        // 判断userId是否为空
        if (StrUtil.isEmpty(userId)) {
            ObjectMapper objectMapper = new ObjectMapper();
            servletResponse.getWriter().write(objectMapper.writeValueAsString(ResultView.fail()));
            return;
        }

        HeaderMapRequestWrapper headerMapRequestWrapper = new HeaderMapRequestWrapper(httpServletRequest);
        headerMapRequestWrapper.addHeader("userId", userId);

        filterChain.doFilter(headerMapRequestWrapper, servletResponse);


    }
}
