package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.entity.Order;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public String getCurrentOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1");
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public boolean checkIfOrderExists(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
        return set.next();
    }

    @Override
    public boolean placeOrder(Order order) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",order.getOrderId(),order.getOrderDate(),order.getCustomerId());
    }

}
