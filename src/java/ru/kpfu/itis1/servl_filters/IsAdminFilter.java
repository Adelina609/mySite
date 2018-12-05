package ru.kpfu.itis1.servl_filters;

import ru.kpfu.itis1.services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin")
public class IsAdminFilter implements Filter {

    private String admin_cookie = UserService.md5Apache("katyn.kotova@mail.ru");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies = request.getCookies();
        boolean isAdmin = false;
        for(Cookie cookie :  cookies){
            if(cookie.getName().equals("email")){
                if(cookie.getValue().equals(admin_cookie)) {
                    isAdmin = true;
                }
            }
        }
        if(isAdmin){
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/home");
        }
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
