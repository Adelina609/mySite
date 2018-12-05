package ru.kpfu.itis1.servl_filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/myarea")
public class SameFilterForArea implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if(session.getAttribute("email") != null) {
            Cookie[] cookies = request.getCookies();
            boolean isLogged = false;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    isLogged = true;
                }
            }
            if (isLogged) {
                filterChain.doFilter(request, response);
            }
        }
        else {
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
