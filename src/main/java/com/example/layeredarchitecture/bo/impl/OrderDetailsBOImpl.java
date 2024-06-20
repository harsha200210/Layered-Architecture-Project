package com.example.layeredarchitecture.bo.impl;

import com.example.layeredarchitecture.bo.OrderDetailsBO;
import com.example.layeredarchitecture.dao.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailsDAOImpl;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public class OrderDetailsBOImpl implements OrderDetailsBO {
    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();

    @Override
    public boolean saveOrderDetail(String orderId, OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.saveOrderDetail(orderId, orderDetailDTO);
    }
}
