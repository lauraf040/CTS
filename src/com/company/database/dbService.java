package com.company.database;

import com.company.contracts.dbManager;

import java.sql.Connection;
import java.sql.SQLException;

public class dbService {

    private dbManager dbManager;
    public dbService(dbManager dbManager){
        this.dbManager = dbManager;
    }
    public void execute(){
        dbManager = new sqlService();
    }
}
