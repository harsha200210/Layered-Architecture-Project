package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.SuperDAO;
import com.example.layeredarchitecture.entity.OrderDetail;

import java.sql.SQLException;

public interface OrderDetailsDAO extends SuperDAO {
    boolean saveOrderDetail(String orderId, OrderDetail orderDetail) throws SQLException, ClassNotFoundException;
}
