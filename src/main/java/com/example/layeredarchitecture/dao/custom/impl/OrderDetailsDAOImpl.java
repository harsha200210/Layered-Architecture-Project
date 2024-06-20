package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public boolean saveOrderDetail(String orderId, OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",orderId,orderDetailDTO.getItemCode(),orderDetailDTO.getUnitPrice(),orderDetailDTO.getQty());
    }
}
