package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBO;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.dto.ItemDTO;
import com.example.layeredarchitecture.dto.OrderDTO;
import com.example.layeredarchitecture.dto.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PurchaseOrderBO extends SuperBO {
    String getCurrentOrderId() throws SQLException, ClassNotFoundException;

    boolean checkIfOrderExists(String orderId) throws SQLException, ClassNotFoundException;

    boolean placeOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;

    ItemDTO getObjectItem(String code) throws SQLException, ClassNotFoundException;

    boolean existItem(String code) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllItemIds() throws SQLException, ClassNotFoundException;

    boolean updateQty(ItemDTO item) throws SQLException, ClassNotFoundException;

    ItemDTO searchItemCode(String code) throws SQLException, ClassNotFoundException;

    CustomerDTO getObjectCustomer(String newValue) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllCustomerIds() throws SQLException, ClassNotFoundException;

    boolean saveOrderDetail(String orderId, OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException;

    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);
}
