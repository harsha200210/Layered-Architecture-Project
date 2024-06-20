package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PurchaseOrderBO {
    public String getCurrentOrderId() throws SQLException, ClassNotFoundException;

    public boolean checkIfOrderExists(String orderId) throws SQLException, ClassNotFoundException;

    public boolean placeOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;

    public ItemDTO getObjectItem(String code) throws SQLException, ClassNotFoundException;

    public boolean existItem(String code) throws SQLException, ClassNotFoundException;

    public ArrayList<String> getAllItemIds() throws SQLException, ClassNotFoundException;

    public boolean updateQty(ItemDTO item) throws SQLException, ClassNotFoundException;

    public ItemDTO searchItemCode(String code) throws SQLException, ClassNotFoundException;

    public CustomerDTO getObjectCustomer(String newValue) throws SQLException, ClassNotFoundException;

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<String> getAllCustomerIds() throws SQLException, ClassNotFoundException;

    public boolean saveOrderDetail(String orderId, OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException;

    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);
}
