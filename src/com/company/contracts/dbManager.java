package com.company.contracts;

import java.sql.Connection;
import java.sql.SQLException;

public interface dbManager {
    void connect(Connection connection) throws SQLException, ClassNotFoundException;
    void createTable(Connection connection) throws SQLException;
    void insertData(Connection connection) throws SQLException;
    void readData(Connection connection) throws SQLException;
    void disconnect(Connection connection) throws SQLException;

}
