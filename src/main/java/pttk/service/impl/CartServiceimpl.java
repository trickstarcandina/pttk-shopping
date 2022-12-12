package pttk.service.impl;

import pttk.dao.order.CartDAO;
import pttk.dao.order.impl.CartDAOImpl;
import pttk.model.book.ItemBook;
import pttk.model.order.Cart;
import pttk.service.CartService;

public class CartServiceimpl implements CartService {

    private final CartDAO cartDAO = new CartDAOImpl();
    @Override
    public Cart getCartByOrderId(int orderId) {
        return null;
    }

    @Override
    public Cart getCartByCustomerId(int customerId, String status) {
        return cartDAO.getCartByCustomerId(customerId, status);
    }

    @Override
    public Boolean addBookToCart(ItemBook itemBook) {
        return null;
    }

    @Override
    public Boolean addClothesToCart(ItemBook itemBook) {
        return null;
    }

    @Override
    public Long create(int customerId) {
        return cartDAO.create(customerId);
    }

    @Override
    public Cart update(Cart cart) {
        return cartDAO.update(cart);
    }
}
