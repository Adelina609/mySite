package ru.kpfu.itis1.servlets;

import ru.kpfu.itis1.objects.UserSimple;
import ru.kpfu.itis1.repositories.UserRepository;
import ru.kpfu.itis1.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass1 = req.getParameter("pass");
        if (UserRepository.getUserByEmail(email) != null &&
                UserRepository.getUserByEmail(email).getPassword().equals(pass1)) {
//            HttpSession session = req.getSession();
//            session.setAttribute("email", email);
//            session.setMaxInactiveInterval(60);
            System.out.println("in Auth servlet");
            Cookie userName = new Cookie("emailvvv", "value");
            userName.setMaxAge(60);
            resp.addCookie(userName);
//            if(UserService.isAdmin(email, pass1)) {
//                session.setAttribute("userRole", "admin");
//                req.setAttribute("isAdmin", "admin");
//                resp.sendRedirect(req.getContextPath() + "/signinadmin");
//            } else {
//                session.setAttribute("userRole", "user");
//                req.setAttribute("isAdmin", "user");
//                resp.sendRedirect(req.getContextPath() + "/signupresult");
//            }
            System.out.println("VOSHLAAA" + Arrays.toString(req.getCookies()));
            System.out.println(req.getRequestURI() + "123");
            resp.sendRedirect(req.getContextPath() + "/home");
        }
//            UserSimple user = new UserSimple(email, pass1);
//            UserRepository.add(user);
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
        else if(UserRepository.getUserByEmail(email) == null){
            req.setAttribute("emailValue", req.getParameter("email"));
            req.setAttribute("email_error", "Пользователь не найден");
            resp.sendRedirect(req.getContextPath() + "/home#openModal");
        } else if(!UserRepository.getUserByEmail(email).getPassword().equals(pass1)){
            req.setAttribute("emailValue", req.getParameter("email"));
            req.setAttribute("pass_error", "Неверный пароль");
            resp.sendRedirect(req.getContextPath() + "/home#openModal");
        }
    }

}
