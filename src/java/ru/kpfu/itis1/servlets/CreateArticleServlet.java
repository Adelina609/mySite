package ru.kpfu.itis1.servlets;

import ru.kpfu.itis1.objects.Article;
import ru.kpfu.itis1.repositories.ArticlesRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createarticle")
public class CreateArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/jsp/about.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String text = req.getParameter("text");
        Cookie[] cookies = req.getCookies();
        String user = "admin";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                System.out.println(cookie.getValue());
                user = cookie.getValue();
            }
        }
        ArticlesRepository.add(new Article(user, title, text));
        resp.sendRedirect(req.getContextPath() + "/sent");
    }
}
