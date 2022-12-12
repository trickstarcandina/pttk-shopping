package pttk.controller;

import pttk.dao.order.OrderDAO;
import pttk.dao.order.PaymentDAO;
import pttk.dao.order.ShipmentServiceDAO;
import pttk.dao.order.impl.OrderDAOImpl;
import pttk.dao.order.impl.PaymentDAOImpl;
import pttk.dao.order.impl.ShipmentServiceDAOImpl;
import pttk.model.book.ItemBook;
import pttk.model.book.LineItemBook;
import pttk.model.clothes.ItemClothes;
import pttk.model.clothes.LineItemClothes;
import pttk.model.customer.Customer;
import pttk.model.order.*;
import pttk.service.CartService;
import pttk.service.impl.CartServiceimpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/order"})
public class OrderController extends HttpServlet {

    private final CartService cartService = new CartServiceimpl();
    private final OrderDAO orderDAO = new OrderDAOImpl();
    private final ShipmentServiceDAO shipmentServiceDAO = new ShipmentServiceDAOImpl();
    private final PaymentDAO paymentDAO = new PaymentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String view = "views/web/list-order.jsp";
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        List<Order> orderList = orderDAO.findAllByCustomerId(customer.getId());
        List<String> listPayment = new ArrayList<>();
        orderList.forEach( order -> {
            if(order.getPayment() instanceof Cash) {
                listPayment.add("Cash");
            } else {
                listPayment.add("Credit");
            }
        });
        request.setAttribute("listPayment", listPayment);
        if (orderList.isEmpty()) {
            request.setAttribute("message", "Bạn chưa có đơn hàng nào cả");
        }
        request.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            Order order = new Order();
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            Cart cart = cartService.getCartByCustomerId(customer.getId(), "active");
            cart.setCartStatus("not active");
            order.setCart(cart);
            order.setCustomer(customer);
            order.setDate(new Date());
            order.setStatus("Đang xác nhận");
            Shipment shipment = new Shipment();
            String shipmentServiceId = request.getParameter("shipmentService");
            ShipmentService shipmentService = shipmentServiceDAO.findById(Integer.parseInt(shipmentServiceId));
            String address = request.getParameter("address");
            shipment.setShipmentService(shipmentService);
            shipment.setAddressReceive(address);
            order.setShipment(shipment);
            Payment payment = new Payment();
            String paymentType = request.getParameter("payment");
            if (paymentType.equals("Cash")) {
                payment = new Cash();
            }
            else {
                String creditName = request.getParameter("creditName");
                String creditId = request.getParameter("creditId");
                payment = new Credit(creditId, creditName);
            }
            payment.setAmount(cart.getTotalPrice() + shipmentService.getShipPrice());
            order.setPayment(payment);
            orderDAO.save(order);
            response.sendRedirect("/order");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }
}
