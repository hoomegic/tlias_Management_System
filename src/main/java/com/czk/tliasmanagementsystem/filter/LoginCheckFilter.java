package com.czk.tliasmanagementsystem.filter;

import com.czk.tliasmanagementsystem.utils.CurrentHolder;
import com.czk.tliasmanagementsystem.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        //1、将ServeletRequest强转成HttpServeletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //2、获取url
        String url = request.getRequestURL().toString();
        //3、是否包含login，包含则放行
        if(url.contains("/login")){
            chain.doFilter(request,response);
            return ;
        }
        //4、不包含则解析jwt
        else{
            //5.没有或者解析错误都返回登录
            String token = request.getHeader("token");
            if(token == null || token.isEmpty()) {
                response.getWriter().write("123");
                response.setStatus(401);
                return;
            }
            try{
                Claims claims = JwtUtils.parseJWT(token);

                CurrentHolder.setCurrentLocal(Integer.valueOf(claims.get("id").toString()));

            }catch (Exception o){
                response.getWriter().write("1234");
                response.setStatus(401);
            }

        }
        //放行
        chain.doFilter(request,response);

        CurrentHolder.removeCurrentLocal();
    }

}
