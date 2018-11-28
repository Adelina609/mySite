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
        System.out.println(email+pass1+username);

        if (pass1.equals(pass2) && UserRepository.getUserByEmail(email) == null) {
            HttpSession session = req.getSession();
            session.setAttribute("email", email);
            session.setMaxInactiveInterval(2*60);
//            Cookie userName = new Cookie(email, UserService.md5Apache(email));
//            userName.setMaxAge(2*60);
//            resp.addCookie(userName);
//            if(UserService.isAdmin(email, pass1)) {
//                session.setAttribute("userRole", "admin");
//                req.setAttribute("isAdmin", "admin");
//                resp.sendRedirect(req.getContextPath() + "/signinadmin");
//            } else {
//                session.setAttribute("userRole", "user");
//                req.setAttribute("isAdmin", "user");
//                resp.sendRedirect(req.getContextPath() + "/signupresult");
//            }
            UserSimple user = new UserSimple(email, pass1, username);
            UserRepository.add(user);
            resp.sendRedirect(req.getContextPath() + "/home");
        }
//            UserSimple user = new UserSimple(email, pass1);
//            UserRepository.add(user);
        else if(!pass1.equals(pass2)) {
            req.setAttribute("emailValue", req.getParameter("email"));
            req.setAttribute("nameValue", req.getParameter("username"));
            req.setAttribute("pass_error", "PASSWORD!");
            System.out.println("Пароли не совпадают");
            req.getRequestDispatcher("WEB-INF/views/jsp/registration.jsp").forward(req, resp);
//            System.out.println("dopost");
//            req.getRequestDispatcher("/WEB-INF/views/first_form.jsp").forward(req, resp);

//            req.setAttribute("emailValue", req.getParameter("email"));
//
//            if (!UserService.checkEmail(email)) {
//                req.setAttribute("email_error", "Enter the right email");
//                req.getRequestDispatcher("/WEB-INF/views/first_form.jsp").forward(req, resp);
//            }
//
//            if (!UserService.checkPassword(pass1)) {
//                req.setAttribute("pass_error", "Password should be more than 5 symbols");
//                req.getRequestDispatcher("/WEB-INF/views/first_form.jsp").forward(req, resp);
//            }
        } else if(UserRepository.getUserByEmail(email) != null){
            req.setAttribute("emailValue", req.getParameter("email"));
            req.setAttribute("nameValue", req.getParameter("username"));
            System.out.println("USER IS EXISTING!");
            req.setAttribute("email_error", "USER IS EXISTING!!");
            req.getRequestDispatcher("WEB-INF/views/jsp/registration.jsp").forward(req, resp);
        }
    }
}