package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.PurchaseOrderBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailsDAOImpl;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {
    OrderDAO orderDAO;
    ItemDAO itemDAO;
    CustomerDAO customerDAO;
    OrderDetailsDAO orderDetailsDAO;

    public PurchaseOrderBOImpl() {
        this.orderDAO = DAOFactory.getDAO(DAOFactory.DAOType.ORDER);
        this.itemDAO = DAOFactory.getDAO(DAOFactory.DAOType.ITEM);;
        this.customerDAO = DAOFactory.getDAO(DAOFactory.DAOType.CUSTOMER);;
        this.orderDetailsDAO = DAOFactory.getDAO(DAOFactory.DAOType.ORDERDETAILS);;
    }

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

    @Override
    public ItemDTO getObjectItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.getObject(code);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public ArrayList<String> getAllItemIds() throws SQLException, ClassNotFoundException {
        return itemDAO.getAllIds();
    }

    @Override
    public boolean updateQty(ItemDTO item) throws SQLException, ClassNotFoundException {
        return itemDAO.updateQty(item);
    }

    @Override
    public ItemDTO searchItemCode(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.findItem(code);
    }

    @Override
    public CustomerDTO getObjectCustomer(String newValue) throws SQLException, ClassNotFoundException {
        return customerDAO.getObject(newValue);
    }

    @Override
    public ArrayList<String> getAllCustomerIds() throws SQLException, ClassNotFoundException {
        return customerDAO.getAllIds();
    }

    @Override
    public boolean saveOrderDetail(String orderId, OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.saveOrderDetail(orderId, orderDetailDTO);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
        /*Transaction*/
        OrderDTO orderDTO = new OrderDTO(orderId, orderDate, customerId);
        try {
            Connection connection = DBConnection.getDbConnection().getConnection();
            /*if order id already exist*/
            if (checkIfOrderExists(orderDTO.getOrderId())) {
                return false;
            }

            connection.setAutoCommit(false);

            if (!placeOrder(orderDTO)) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            for (OrderDetailDTO detail : orderDetails) {
                OrderDetailDTO orderDetailDTO = new OrderDetailDTO(detail.getItemCode(), detail.getQty(), detail.getUnitPrice());
                if (!saveOrderDetail(orderDTO.getOrderId(),orderDetailDTO)) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

//                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                ItemDTO itemDTO = new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
                if (!(updateQty(itemDTO))) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public ItemDTO findItem(String code) {
        try {
            return searchItemCode(code);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}