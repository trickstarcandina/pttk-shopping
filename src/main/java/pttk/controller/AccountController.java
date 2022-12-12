package pttk.controller;

import pttk.model.customer.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import pttk.model.customer.Address;
import pttk.model.customer.FullName;
import pttk.service.CustomerService;
import pttk.service.impl.CustomerServiceImpl;

@WebServlet(urlPatterns = {"/change-password", "/my-account"})
public class AccountController extends HttpServlet {

    private final CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serveletPath = request.getServletPath();

        if (serveletPath.equals("/change-password")) {
            String message = request.getParameter("message");

            if (message != null) {
                if (message.equals("password_incorrect")) {
                    request.setAttribute("message", "Password is Wrong !");
                    request.setAttribute("alert", "danger");
                }
                if (message.equals("re-password_incorrect")) {
                    request.setAttribute("message", "New Password Not Match");
                    request.setAttribute("alert", "danger");
                }
                if (message.equals("not_null")) {
                    request.setAttribute("message", "Fields not empty !");
                    request.setAttribute("alert", "danger");
                }
                if (message.equals("server-error")) {
                    request.setAttribute("message", "Server Error!");
                    request.setAttribute("alert", "danger");
                }
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/information/change-password.jsp");
            dispatcher.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            request.setAttribute("customer", customer);
            String message = request.getParameter("message");
            if (message != null) {
                if (message.equals("server-error")) {
                    request.setAttribute("message", "Server Error !");
                    request.setAttribute("alert", "danger");
                }
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/information/change-infomation.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serveletPath = request.getServletPath();
        request.setCharacterEncoding("UTF-8");
        try {
            if (serveletPath.equals("/change-password")) {
                String password = request.getParameter("password");
                String newPassword = request.getParameter("new-password");
                String rePassword = request.getParameter("re-password");
                // validate input
                if (password != null && rePassword != null && newPassword != null
                        && !newPassword.trim().isEmpty() && !password.trim().isEmpty() && !rePassword.trim().isEmpty()) {
                    //validate re-password
                    if (!newPassword.equals(rePassword)) {
                        response.sendRedirect(request.getContextPath() + "/change-password?message=re-password_incorrect");
                    } else {
                        //check username exits or not
                        HttpSession session = request.getSession();
                        Customer customer = (Customer) session.getAttribute("customer");

                        //check password
                        if (customer.getAccount().getPassword().equals(password)) {
                            customer.getAccount().setPassword(newPassword);
                            //update DB 
                            Boolean isUpdated = customerService.updateCustomer(customer);
                            if (isUpdated == true) {
                                session.setAttribute("customer", customer);
                                Cookie[] cookies = request.getCookies();
                                // reset cookie
                                for (Cookie cookie : cookies) {
                                    if (cookie.getName().equals("password")) {
                                        cookie.setValue(newPassword);
                                        response.addCookie(cookie);
                                    }
                                }
                                session.setAttribute("customer", customer);
                                request.setAttribute("message", "Update Password Success !");
                                request.setAttribute("alert", "success");
                                RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/information/change-password.jsp");
                                dispatcher.forward(request, response);
                            } else {
                                response.sendRedirect(request.getContextPath() + "/change-password?message=server-error");

                            }
                        } else {
                            response.sendRedirect(request.getContextPath() + "/change-password?message=password_incorrect");
                        }
                    }
                } else {
                    response.sendRedirect(request.getContextPath() + "/change-password?message=not_null");
                }
            } else {
                String firstName = request.getParameter("first-name");
                String middleName = request.getParameter("middle-name");
                String lastName = request.getParameter("last-name");
                String nation = request.getParameter("nation");
                String city = request.getParameter("city");
                String district = request.getParameter("district");
                String street = request.getParameter("street");
                String numberHouse = request.getParameter("number-house");
                FullName fullName = new FullName(firstName, middleName, lastName);
                Address address = new Address(numberHouse, street, district, city, nation);
                HttpSession session = request.getSession();
                Customer customer = (Customer) session.getAttribute("customer");
                Customer newCustomer = new Customer(customer.getAccount(), address, fullName, "customer",customer.getCart());
                newCustomer.setId(customer.getId());
                System.out.println("pttk.controller.AccountController.doPost()------------");
                Boolean isUpdated = customerService.updateCustomer(newCustomer);
                System.out.println("pttk.controller.AccountController.doPost()------------"+isUpdated+"----");
                
                if (isUpdated == true) {
                    session.setAttribute("customer", newCustomer);
                    request.setAttribute("message", "Update Success !");
                    request.setAttribute("alert", "success");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/information/change-infomation.jsp");
                    dispatcher.forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/my-account?message=server-error");

                }

            }
        } catch (Exception exception) {
            exception.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
