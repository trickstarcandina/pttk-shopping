package pttk.controller;

import pttk.dao.order.OrderDAO;
import pttk.dao.order.impl.OrderDAOImpl;
import pttk.model.order.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/admin-order"})
public class AdminOrderController extends HttpServlet {

    private final OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String view = "views/admin/order/list-order.jsp";
            List<Order> orderList = orderDAO.findAll();
            request.setAttribute("orderList", orderList);
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String view = "views/admin/order/list-order.jsp";
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            int id = Integer.parseInt(request.getParameter("id"));
            String status = request.getParameter("status");
            orderDAO.update(status,id);
            request.setAttribute("messageResponse", "Cập nhật đơn hàng thành công");
            request.setAttribute("alert", "success");
            List<Order> orderList = orderDAO.findAll();
            request.setAttribute("orderList", orderList);
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }
}
