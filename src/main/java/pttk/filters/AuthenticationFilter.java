package pttk.filters;



import pttk.model.customer.Customer;
import pttk.service.CustomerService;
import pttk.service.impl.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    private ServletContext context;

    private final CustomerService customerService = new CustomerServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        Customer model = (Customer) session.getAttribute("customer");

        //check logged in
        if (model != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {

            //check cookie for remember me
            Cookie[] cookies = request.getCookies();

            if(cookies == null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                String username = "", password = "";
                // get cookie for check logged in
                for (Cookie cookie : cookies) {
                    if (cookie.getName() != null && cookie.getName().equals("username")) {
                        username = cookie.getValue();
                    }
                    if (cookie.getName() != null && cookie.getName().equals("password")) {
                        password = cookie.getValue();
                    }
                }

                //check cookie for log in
                if (username.trim().length() > 0 && password.trim().length() > 0) {

                    Customer customer = customerService.findByUserNameAndPassword(username, password);
                    if (customer != null) {
                        session.setAttribute("customer", customer);
                        response.sendRedirect("/home");
                        return;
                    } else {
                        filterChain.doFilter(servletRequest, servletResponse);
                    }
                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
