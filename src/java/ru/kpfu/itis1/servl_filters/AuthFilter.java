package ru.kpfu.itis1.servl_filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/createarticle")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies = request.getCookies();
        String loginURI = request.getContextPath() + "#openModal";
        boolean isLogged = false;
        for(Cookie cookie :  cookies){
            if(cookie.getName().equals("emailvvv")){
                isLogged = true;
            }
        }
        if(isLogged){
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
