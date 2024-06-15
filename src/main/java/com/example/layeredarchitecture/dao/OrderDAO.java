package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public interface OrderDAO {
    String getCurrentOrderId() throws SQLException, ClassNotFoundException;

    boolean checkIfOrderExists(String orderId) throws SQLException, ClassNotFoundException;

    boolean placeOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
}
