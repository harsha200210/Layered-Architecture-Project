package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.SuperDAO;
import com.example.layeredarchitecture.entity.Order;

import java.sql.*;

public interface OrderDAO extends SuperDAO {
    String getCurrentOrderId() throws SQLException, ClassNotFoundException;

    boolean checkIfOrderExists(String orderId) throws SQLException, ClassNotFoundException;

    boolean placeOrder(Order order) throws SQLException, ClassNotFoundException;

}
