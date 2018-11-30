package ru.kpfu.itis1.servlets;

import ru.kpfu.itis1.objects.UserSimple;
import ru.kpfu.itis1.repositories.UserRepository;
import ru.kpfu.itis1.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/jsp/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass1 = req.getParameter("password1");
        String pass2 = req.getParameter("password2");
        String username = req.getParameter("username");

        if (pass1.equals(pass2) && UserRepository.getUserByEmail(email) == null
        && UserService.checkEmail(email)) {
            Cookie userEmail = new Cookie("email", UserService.md5Apache(email));
            Cookie userName = new Cookie("username", username);
            userName.setMaxAge(60);
            resp.addCookie(userName);
            resp.addCookie(userEmail);
            UserSimple user = new UserSimple(email, pass1, username);
            UserRepository.add(user);
            resp.sendRedirect(req.getContextPath() + "/home");
        }
        else if(!pass1.equals(pass2)) {
            req.setAttribute("emailValue", req.getParameter("email"));
            req.setAttribute("nameValue", req.getParameter("username"));
            req.setAttribute("pass_error", "Passwords don't equals");
            System.out.println("Passwords don't equals");
            req.getRequestDispatcher("WEB-INF/views/jsp/registration.jsp").forward(req, resp);
        } else if(UserRepository.getUserByEmail(email) != null){
            req.setAttribute("emailValue", req.getParameter("email"));
            req.setAttribute("nameValue", req.getParameter("username"));
            System.out.println("USER IS EXISTING!");
            req.setAttribute("email_error", "User is existing");
            req.getRequestDispatcher("WEB-INF/views/jsp/registration.jsp").forward(req, resp);
        } else if(!UserService.checkEmail(email)){
            req.setAttribute("emailValue", req.getParameter("email"));
            req.setAttribute("nameValue", req.getParameter("username"));
            System.out.println("Enter the right email");
            req.setAttribute("email_error", "Enter the right email");
            req.getRequestDispatcher("WEB-INF/views/jsp/registration.jsp").forward(req, resp);
        }
    }
}