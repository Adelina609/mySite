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
            System.out.println("in Auth servlet");
            Cookie userEmail = new Cookie("email", UserService.md5Apache(email));
            Cookie userName = new Cookie("username",
                    UserRepository.getUserByEmail(email).getNickname());
            userName.setMaxAge(60);
            resp.addCookie(userEmail);
            resp.addCookie(userName);
            System.out.println("VOSHLAAA" + Arrays.toString(req.getCookies()));
            System.out.println(req.getRequestURI() + "123");
            resp.sendRedirect(req.getContextPath() + "/home");
        }
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
