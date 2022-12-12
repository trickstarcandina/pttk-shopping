package pttk.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = { "/logout"})

public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //remove session
            HttpSession session = request.getSession();
            session.invalidate();

            //remove cookie
            Cookie cookieUsername = new Cookie("username", "");
            cookieUsername.setMaxAge(0);
            response.addCookie(cookieUsername);

            Cookie cookiePassword = new Cookie("password", "");
            cookiePassword.setMaxAge(0);
            response.addCookie(cookiePassword);

            response.sendRedirect("/home");
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
