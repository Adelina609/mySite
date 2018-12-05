package ru.kpfu.itis1.servlets;

import ru.kpfu.itis1.objects.Article;
import ru.kpfu.itis1.repositories.ArticlesRepository;
import ru.kpfu.itis1.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/myarea")
public class PersonalAreaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String user = "admin";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                user = cookie.getValue();
                System.out.println(user);
            }
        }
        List<Article> articles = ArticlesRepository.getArticlesByUser(user);
        req.setAttribute("articles", articles);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/views/jsp/personal_area.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("editText");
        UserRepository.updateUsername(username);
        if(req.getParameter("del") != null){
            UserRepository.deleteUser(req.getParameter("username"));
        }
    }
}
