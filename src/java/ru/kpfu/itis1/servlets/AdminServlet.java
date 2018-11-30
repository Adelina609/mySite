package ru.kpfu.itis1.servlets;

import ru.kpfu.itis1.objects.Article;
import ru.kpfu.itis1.repositories.ArticlesRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articles = ArticlesRepository.getArticles("admin");
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/WEB-INF/views/jsp/personal_area.jsp").forward(req, resp);
    }
}
