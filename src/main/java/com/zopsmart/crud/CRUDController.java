package com.zopsmart.crud;

import java.sql.SQLException;

public class CRUDController {
    public void start() throws SQLException {
        CRUDDao crudDao = new CRUDDao();
        crudDao.addStudent(1, "ab", 22);
        crudDao.addStudent(2, "v kohli", 24);

        System.out.println(crudDao.getStudent(1));
    }
}
