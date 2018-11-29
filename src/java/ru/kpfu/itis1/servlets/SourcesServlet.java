package ru.kpfu.itis1.servlets;

import ru.kpfu.itis1.objects.Source;
import ru.kpfu.itis1.repositories.SourcesRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/sources")
public class SourcesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Source> sources = SourcesRepository.getSources();
        req.setAttribute("sources", sources);
        req.getRequestDispatcher("/WEB-INF/views/jsp/source.jsp").forward(req, resp);
    }
}
