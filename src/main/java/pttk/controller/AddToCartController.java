package pttk.controller;

import pttk.model.book.ItemBook;
import pttk.model.clothes.ItemClothes;
import pttk.model.order.Cart;
import pttk.model.customer.Customer;
import pttk.model.shoes.ItemShoes;
import pttk.service.*;
import pttk.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addToCart"})
public class AddToCartController extends HttpServlet {

    private final CartService cartService = new CartServiceimpl();
    private final ItemBookService itemBookService = new ItemBookServiceImpl();
    private final ItemClothesService itemClothesService = new ItemClothesServiceImpl();
    private final ItemElectronicService itemElectronicService = new ItemElectronicServiceImpl();
    private final ItemShoesService itemShoesService = new ItemShoesServiceImpl();
    private final LineItemBookService lineItemBookService = new LineItenBookServiceImpl();
    private final LineItemShoesService lineItemShoesService = new LineItemShoesServiceImpl();
    private final LineItemClothesService lineItemClothesService = new LineItemClothesServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            Cart cart = cartService.getCartByCustomerId(customer.getId(), "active");
            if(cart == null) {
                Long ans = cartService.create(customer.getId());
            }
            cart = cartService.getCartByCustomerId(customer.getId(),"active");
            String type = request.getParameter("type");
            Long ans = 0L;
            switch (type) {
                case "book" :
                    int itemBookId = Integer.parseInt((String) request.getParameter("id"));
                    int quantityB = Integer.parseInt((String) request.getParameter("quantity"));
                    ans = lineItemBookService.create(cart.getId(), itemBookId, quantityB);
                    ItemBook itemBook = itemBookService.findById(itemBookId);
                    cart.setTotalPrice(cart.getTotalPrice() + itemBook.getPrice()*quantityB );
                    break;
                case "clothes" :
                    int itemClothesId = Integer.parseInt((String) request.getParameter("id"));
                    int quantityC = Integer.parseInt((String) request.getParameter("quantity"));
                    ans = lineItemClothesService.create(cart.getId(), itemClothesId, quantityC);
                    ItemClothes itemClothes = itemClothesService.findById(itemClothesId);
                    cart.setTotalPrice(cart.getTotalPrice() + itemClothes.getPrice()*quantityC );
                    break;
                case "shoes" :
                    int itemShoesId = Integer.parseInt((String) request.getParameter("id"));
                    int quantityS = Integer.parseInt((String) request.getParameter("quantity"));
                    ans = lineItemShoesService.create(cart.getId(), itemShoesId, quantityS);
                    ItemShoes itemShoes = itemShoesService.findShoesById(itemShoesId);
                    cart.setTotalPrice(cart.getTotalPrice() + itemShoes.getPrice()*quantityS );
                    break;
            }
            cartService.update(cart);
            response.sendRedirect("/cart");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
