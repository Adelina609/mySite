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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class MainPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articles = ArticlesRepository.getArticles();
        Cookie[] cookies = req.getCookies();
        String user = "admin";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("emailvvv")) {
                user = cookie.getName();
            }
        }
//        articles.add(new Article(user, "tile", "The getElementById() method returns the element that has the ID attribute with the specified value.\n" +
//                "\n" +
//                "This method is one of the most common methods in the HTML DOM, and is used almost every time you want to manipulate, or get info from, an element on your document.\n" +
//                "\n" +
//                "Returns null if no elements with the specified ID exists.\n" +
//                "\n" +
//                "An ID should be unique within a page. However, if more than one element with the specified ID exists, the getElementById() method returns the first element in the source code.\n" +
//                "\n"));
//        articles.add(new Article("admin", "tihjkvhble", "rtfyghjkmhbvcxddrtyuijknbvcfg"));
//        articles.add(new Article("admin", "tilvh bne", "rtfyghjkmhbvcxddrtyuijknbvcfg"));
//        articles.add(new Article("admin", "tyhbjile", "rtfyghjkmhbvcxddrtyuijknbvcfg"));
        req.setAttribute("articles", articles);

            req.getRequestDispatcher("/WEB-INF/views/jsp/index.jsp").forward(req, resp);

    }
}