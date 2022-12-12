package pttk.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.*;
import pttk.model.book.LineItemBook;
import pttk.model.clothes.LineItemClothes;
import pttk.model.customer.Customer;
import pttk.model.electronic.LineItemElectronic;
import pttk.model.shoes.LineItemShoes;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseEntity {
    private String cartStatus;
    private Float totalPrice;
    private List<LineItemBook> lineItemBooks;
    private List<LineItemElectronic> lineItemElectronics;
    private List<LineItemClothes> lineItemClothes;
    private List<LineItemShoes> lineItemShoes;
    private Customer customer;
}
