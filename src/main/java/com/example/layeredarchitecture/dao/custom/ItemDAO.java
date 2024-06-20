package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.entity.Item;

import java.sql.*;

public interface ItemDAO extends CrudDAO<Item> {
    boolean updateQty(Item item) throws SQLException, ClassNotFoundException;

    Item findItem(String code) throws SQLException, ClassNotFoundException;
}
