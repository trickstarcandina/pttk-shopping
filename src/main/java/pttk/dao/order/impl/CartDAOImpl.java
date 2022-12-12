package pttk.dao.order.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.book.LineItemBookDAO;
import pttk.dao.book.impl.LineItemBookDAOImpl;
import pttk.dao.clothes.LineItemClothesDAO;
import pttk.dao.clothes.impl.LineItemClothesDAOImpl;
import pttk.dao.order.CartDAO;
import pttk.dao.shoes.LineItemShoesDAO;
import pttk.dao.shoes.impl.LineItemShoesDAOImpl;
import pttk.model.book.LineItemBook;
import pttk.model.clothes.LineItemClothes;
import pttk.model.electronic.LineItemElectronic;
import pttk.model.order.Cart;
import pttk.model.shoes.LineItemShoes;
import pttk.util.impl.*;

import java.util.List;

public class CartDAOImpl extends BaseDAOImpl implements CartDAO {

    private final LineItemBookDAO lineItemBookDAO = new LineItemBookDAOImpl();
    private final LineItemClothesDAO lineItemClothesDAO = new LineItemClothesDAOImpl();
    private final LineItemShoesDAO lineItemShoesDAO = new LineItemShoesDAOImpl();

    @Override
    public Cart getCartByCustomerId(int customerId, String status) {
        String sql = "SELECT * FROM cart WHERE CustomerId = ? and CartStatus = ?";
        List<Cart> cartList = query(sql, new CartMapper(), customerId, status);
        if (!cartList.isEmpty()) {
            return findById(cartList.get(0).getId());
        }
        return null;
    }

    @Override
    public Cart findById(int id) {
        String sql = "SELECT * FROM cart WHERE ID = ?";
        List<Cart> cartList = query(sql, new CartMapper(), id);
        cartList.forEach(cart -> {
            cart.setLineItemBooks(lineItemBookDAO.findByCartId(cart.getId()));
            cart.setLineItemClothes(lineItemClothesDAO.findByCartId(cart.getId()));
        });
        return cartList.isEmpty() ? null : cartList.get(0);
    }

    @Override
    public Long create(int customerId) {
        String sql = "insert into cart(customerId, cartStatus, totalPrice) value (?,?,?)";
        Long ans = insert(sql, customerId,"active",0);
        return ans;
    }

    @Override
    public Cart update(Cart cart) {
        String sql = "UPDATE Cart SET TotalPrice = ?, CartStatus = ? WHERE id = ?";
        update(sql, cart.getTotalPrice(), cart.getCartStatus(), cart.getId());
        return cart;
    }
}
