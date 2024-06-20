package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> items = new ArrayList<>();

        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        while (rst.next()) {
            items.add(new ItemDTO(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand")));
        }
        return items;
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Item WHERE code = ?", code);
    }

    @Override
    public boolean save(ItemDTO item) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
    }

    @Override
    public boolean update(ItemDTO item) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", item.getDescription(), item.getUnitPrice(), item.getQtyOnHand(), item.getCode());
    }

    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtil.execute("SELECT * FROM Item WHERE code = ?", code);
        return set.next();
    }

    @Override
    public String getCurrentId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1");
        if (rst.next()) {
            return rst.getString("code");
        }
        return null;
    }

    @Override
    public ItemDTO getObject(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code = ?", code);
        if (rst.next()){
            ItemDTO item = new ItemDTO(code + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
            return item;
        }
        return null;
    }

    @Override
    public ArrayList<String> getAllIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> itemCodes = new ArrayList<>();

        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        while (rst.next()) {
            itemCodes.add(rst.getString("code"));
        }
        return itemCodes;
    }

    @Override
    public boolean updateQty(ItemDTO item) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", item.getDescription(), item.getUnitPrice(), item.getQtyOnHand(), item.getCode());
    }

    @Override
    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code = ?", code);
        rst.next();
        return new ItemDTO(code, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }
}
