package pttk.service.impl;

import pttk.dao.clothes.LineItemClothesDAO;
import pttk.dao.clothes.impl.LineItemClothesDAOImpl;
import pttk.model.clothes.LineItemClothes;
import pttk.service.LineItemClothesService;

import java.util.List;

public class LineItemClothesServiceImpl implements LineItemClothesService {

    private final LineItemClothesDAO lineItemClothesDAO = new LineItemClothesDAOImpl();

    @Override
    public Long create(int cartId, int itemClothesId, int quantity) {
        return lineItemClothesDAO.create(cartId, itemClothesId, quantity);
    }

    @Override
    public List<LineItemClothes> findByCartId(int cartId) {
        return lineItemClothesDAO.findByCartId(cartId);
    }

    @Override
    public void updateQuantity(int quantity, int id) {
        lineItemClothesDAO.updateQuantity(quantity,id);
    }

    @Override
    public void deleteLineItemClothes(int id) {
        lineItemClothesDAO.deleteLineItemClothes(id);
    }

    @Override
    public LineItemClothes findById(int id) {

        return lineItemClothesDAO.findById(id);
    }
}
