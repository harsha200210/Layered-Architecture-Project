package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        ArrayList<CustomerDTO> customers = new ArrayList<>();

        while (rst.next()) {
            customers.add(new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address")));
        }
        return customers;
    }

    @Override
    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }

    @Override
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getName(),customerDTO.getAddress(),customerDTO.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?",id);
        return rst.next();
    }

    @Override
    public String getCurrentId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
        if (rst.next()) {
            return rst.getString("id");
        }
        return null;
    }

    @Override
    public CustomerDTO getObject(String newValue) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?",newValue + "");
        if (rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));
            return customerDTO;
        }
        return null;
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> customerIds = new ArrayList<>();

        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        while (rst.next()) {
            customerIds.add(rst.getString("id"));
        }
        return customerIds;
    }
}
