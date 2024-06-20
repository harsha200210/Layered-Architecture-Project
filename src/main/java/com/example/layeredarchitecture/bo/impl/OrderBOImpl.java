package com.example.layeredarchitecture.bo.impl;

import com.example.layeredarchitecture.bo.OrderBO;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public String getCurrentOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.getCurrentOrderId();
    }

    @Override
    public boolean checkIfOrderExists(String orderId) throws SQLException, ClassNotFoundException {
        return orderDAO.checkIfOrderExists(orderId);
    }

    @Override
    public boolean placeOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return orderDAO.placeOrder(orderDTO);
    }
}
