package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.entity.OrderDetail;

import java.sql.SQLException;

public interface OrderDetailsDAO {
    boolean saveOrderDetail(String orderId, OrderDetail orderDetail) throws SQLException, ClassNotFoundException;
}
