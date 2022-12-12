package pttk.controller;

import pttk.dao.order.ShipmentServiceDAO;
import pttk.dao.order.impl.ShipmentServiceDAOImpl;
import pttk.model.book.ItemBook;
import pttk.model.book.LineItemBook;
import pttk.model.clothes.ItemClothes;
import pttk.model.clothes.LineItemClothes;
import pttk.model.customer.Customer;
import pttk.model.order.Cart;
import pttk.model.order.ShipmentService;
import pttk.service.*;
import pttk.service.impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

    private final CartService cartService = new CartServiceimpl();
    private final LineItemBookService lineItemBookService = new LineItenBookServiceImpl();
    private final ItemBookService itemBookService = new ItemBookServiceImpl();
    private final LineItemClothesService lineItemClothesService = new LineItemClothesServiceImpl();
    private final ItemClothesService itemClothesService = new ItemClothesServiceImpl();
    private final ShipmentServiceDAO shipmentServiceDAO = new ShipmentServiceDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            Cart cart = cartService.getCartByCustomerId(customer.getId(),"active");
            if (cart == null) {
                Long ans = cartService.create(customer.getId());
            }
            cart = cartService.getCartByCustomerId(customer.getId(),"active");
            List<LineItemBook> listLineBook = lineItemBookService.findByCartId(cart.getId());

            for (LineItemBook lineBook : listLineBook) {
                ItemBook itemBook = itemBookService.findById(lineBook.getItemBook().getId());
                lineBook.setItemBook(itemBook);
            }
            request.setAttribute("listLineBook", listLineBook);
            List<LineItemClothes> listLineClothes = lineItemClothesService.findByCartId(cart.getId());

            for (LineItemClothes lineClothes : listLineClothes) {
                ItemClothes itemClothes = itemClothesService.findById(lineClothes.getItemClothes().getId());
                lineClothes.setItemClothes(itemClothes);
            }
            request.setAttribute("listLineClothes", listLineClothes);
            request.setAttribute("cart", cart);
            String payment = request.getParameter("payment");
            if(payment != null) {
                request.setAttribute("payment", payment);
            } else {
                request.setAttribute("payment", "Cash");
            }
            List<ShipmentService> shipmentServices = shipmentServiceDAO.findAll();
            request.setAttribute("shipmentServices", shipmentServices);
            String shipmentServiceId = request.getParameter("shipmentServiceId");
            ShipmentService shipmentService =shipmentServices.get(0);
            if(shipmentServiceId != null) {
                shipmentService = shipmentServiceDAO.findById(Integer.parseInt(shipmentServiceId));
            }
            request.setAttribute("shipmentService", shipmentService);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/cart.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}
