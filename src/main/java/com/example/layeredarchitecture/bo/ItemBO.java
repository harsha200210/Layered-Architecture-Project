package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;

    boolean saveItem(ItemDTO item) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException;

    boolean existItem(String code) throws SQLException, ClassNotFoundException;

    String getCurrentIdItem() throws SQLException, ClassNotFoundException;

    ItemDTO getObjectItem(String code) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllItemIds() throws SQLException, ClassNotFoundException;

    boolean updateQty(ItemDTO item) throws SQLException, ClassNotFoundException;

    ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;
}
