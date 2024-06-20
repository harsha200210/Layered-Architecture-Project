package com.example.layeredarchitecture.bo.impl;

import com.example.layeredarchitecture.bo.CustomerBO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBO {
    CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.save(customerDTO);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(customerDTO);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public String getCurrentIdCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getCurrentId();
    }

    @Override
    public CustomerDTO getObjectCustomer(String newValue) throws SQLException, ClassNotFoundException {
        return customerDAO.getObject(newValue);
    }

    @Override
    public ArrayList<String> getAllCustomerIds() throws SQLException, ClassNotFoundException {
        return customerDAO.getAllIds();
    }
}
