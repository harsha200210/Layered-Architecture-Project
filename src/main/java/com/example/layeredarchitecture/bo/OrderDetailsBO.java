package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailsBO {
    boolean saveOrderDetail(String orderId, OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException;
}
