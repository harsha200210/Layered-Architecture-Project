package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;

public interface ItemDAO extends CrudDAO<ItemDTO> {
    boolean updateQty(ItemDTO item) throws SQLException, ClassNotFoundException;

    ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;
}
