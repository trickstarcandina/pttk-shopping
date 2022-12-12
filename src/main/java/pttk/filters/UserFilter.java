package pttk.filters;

import pttk.model.customer.Customer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/order", "/order-detail.jsp", "/list-order", "/order-list.jsp", "/my-account", "/account.jsp","/change-password"})
public class UserFilter implements Filter{

    private ServletContext context;

    private final Customer userService = new Customer();

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
        if (model != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(request.getContextPath()+"/login?message=not_logged&alert=danger");
        }
    }

    @Override
    public void destroy() {

    }
}
