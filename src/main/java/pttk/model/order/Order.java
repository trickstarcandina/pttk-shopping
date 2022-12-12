package pttk.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.BaseEntity;
import pttk.model.customer.Customer;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {
    private Date date;
    private String status;
    private Customer customer;
    private Shipment shipment;
    private Payment payment;
    private Cart cart;
}
