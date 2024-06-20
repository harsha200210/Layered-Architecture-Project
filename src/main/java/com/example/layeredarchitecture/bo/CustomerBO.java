package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    String getCurrentIdCustomer() throws SQLException, ClassNotFoundException;

    CustomerDTO getObjectCustomer(String newValue) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllCustomerIds() throws SQLException, ClassNotFoundException;
}
