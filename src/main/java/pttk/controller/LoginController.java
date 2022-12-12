package pttk.controller;


import pttk.constant.SystemConstant;
import pttk.model.customer.Customer;
import pttk.service.CustomerService;
import pttk.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import pttk.model.customer.Account;
import pttk.model.customer.FullName;

@WebServlet(urlPatterns = {"/login","/signup"})
public class LoginController extends HttpServlet {

    private final CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String message1 = request.getParameter("message1");
            
            String message = request.getParameter("message");
            if (message1 != null) {
                if (message1.equals("username_exit")) {
                    request.setAttribute("message1", "Username is already exist");
                    request.setAttribute("alert", "danger");
                }
                if (message1.equals("re-password_incorrect")) {
                    request.setAttribute("message1", "Password is incorrect");
                    request.setAttribute("alert", "danger");
                }
                if (message1.equals("not_null")) {
                    request.setAttribute("message1", "Fields not empty !");
                    request.setAttribute("alert", "danger");
                }
                if(message1.equals("error-server")){
                     request.setAttribute("message1", "Server Error !");
                    request.setAttribute("alert", "danger");
                }
            }
            if (message != null) {
                if (message.equals("username_password_invalid")) {
                    request.setAttribute("message", "Username or Password is invalid !");
                    request.setAttribute("alert", "danger");
                } else if (message.equals("not_logged")) {
                    request.setAttribute("message", "Bạn chưa đăng nhập, vui lòng đăng nhập !");
                    request.setAttribute("alert", "danger");
                }

            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/login.jsp");
            dispatcher.forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            System.out.println("----------" + request.getServletPath()); 
            String path = request.getServletPath().toString();
            if(path.equals("/login")){
                String username = request.getParameter("username");
            String password = request.getParameter("password");
            String isRemember = request.getParameter("remember");
            Customer customer = customerService.findByUserNameAndPassword(username, password);
            // check user
            if (customer != null) {
                // add username and password to cookie when select remember me
                if (isRemember != null) {

                    Cookie cookieUsername = new Cookie("username", customer.getAccount().getUsername());
                    cookieUsername.setMaxAge(SystemConstant.COOKIE_MAX_AGE);
                    response.addCookie(cookieUsername);

                    Cookie cookiePassword = new Cookie("password", customer.getAccount().getPassword());
                    cookiePassword.setMaxAge(SystemConstant.COOKIE_MAX_AGE);
                    response.addCookie(cookiePassword);

                }
                // add user to session
                HttpSession session = request.getSession();
                session.setAttribute("customer", customer);
                response.sendRedirect("/home");

            } else {
                response.sendRedirect(request.getContextPath() + "/login?message=username_password_invalid");
            }
            }
            else{
                String username = request.getParameter("username");
            String password = request.getParameter("password");
            String rePassword = request.getParameter("re-password");
            String firstName = request.getParameter("first-name");
            String middleName = request.getParameter("middle-name");
            String lastName = request.getParameter("last-name");
            // validate input
            if (username != null && password != null && rePassword != null && lastName != null
                    && !username.trim().isEmpty() && !password.trim().isEmpty() && !rePassword.trim().isEmpty() && !lastName.trim().isEmpty()) {

                //validate re-password
                if (!password.equals(rePassword)) {
                    response.sendRedirect(request.getContextPath() + "/login?message1=re-password_incorrect");
                } else {
                    //check username exits or not
                    Customer customer = customerService.findByUserNameAndPassword(username,password);
                    if (customer == null) {
                        FullName fullName = new FullName(firstName, middleName, lastName);
                        Account account = new Account(username, password);
                        customer = new Customer();
                        customer.setAccount(account);
                        customer.setFullName(fullName);
                        Boolean isCreated = customerService.createNewCustomer(customer);
                        if(isCreated){
                            request.setAttribute("message1", "Register Success!");
                            request.setAttribute("alert", "success");
                            request.setAttribute("username", username);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/login.jsp");
                            dispatcher.forward(request, response);
                        }
                        else{
                          response.sendRedirect(request.getContextPath() + "/login?message1=error-server");
                        }
                        
                    } else {
                        response.sendRedirect(request.getContextPath() + "/login?message1=username_exit");
                    }
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/login?message1=not_null");
            }
            }
            
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }
}
