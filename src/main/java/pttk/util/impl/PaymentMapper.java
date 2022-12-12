package pttk.util.impl;

import pttk.model.order.Payment;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class PaymentMapper implements RowMapper<Payment> {

    @Override
    public Payment mapRow(ResultSet rs) {
        try {
            Payment payment = new Payment();
            payment.setId(rs.getInt("ID"));
            payment.setAmount(rs.getFloat("Amount"));
            return payment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
