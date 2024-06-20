package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public interface OrderBO {
    String getCurrentOrderId() throws SQLException, ClassNotFoundException;

    boolean checkIfOrderExists(String orderId) throws SQLException, ClassNotFoundException;

    boolean placeOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
}
