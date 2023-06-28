package com.zopsmart.crud;

import com.zopsmart.crud.CRUDController;

import java.sql.SQLException;

public class CRUDMain {
    public static void main(String[] args) throws SQLException {
        CRUDController crudController = new CRUDController();
        crudController.start();
    }
}
