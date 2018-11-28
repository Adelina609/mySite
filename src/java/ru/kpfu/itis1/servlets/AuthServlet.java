package ru.kpfu.itis1.servlets;

import ru.kpfu.itis1.objects.UserSimple;
import ru.kpfu.itis1.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass1 = req.getParameter("pass");
        if (UserRepository.getUserByEmail(email) != null &&
                UserRepository.getUserByEmail(email).getPassword().equals(pass1)) {
            HttpSession session = req.getSession();
            session.setAttribute("email", email);
            session.setMaxInactiveInterval(60);
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
            System.out.println("VOSHLAAAAAAAAAAAAAAAAAAA");
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
            resp.sendRedirect(req.getContextPath() + "/post");
        } else if(!UserRepository.getUserByEmail(email).getPassword().equals(pass1)){
            req.setAttribute("emailValue", req.getParameter("email"));
            req.setAttribute("pass_error", "Неверный пароль");
            resp.sendRedirect(req.getContextPath() + "/post");
        }
    }

}
