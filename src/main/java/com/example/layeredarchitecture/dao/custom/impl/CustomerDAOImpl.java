package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.entity.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        ArrayList<Customer> customers = new ArrayList<>();

        while (rst.next()) {
            customers.add(new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address")));
        }
        return customers;
    }

    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", customer.getId(), customer.getName(), customer.getAddress());
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?", customer.getName(), customer.getAddress(), customer.getId());
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
    public Customer getObject(String newValue) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?",newValue + "");
        if (rst.next()){
            Customer customer = new Customer(newValue + "", rst.getString("name"), rst.getString("address"));
            return customer;
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
