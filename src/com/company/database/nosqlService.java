package com.company.database;

import com.company.contracts.dbManager;

import java.sql.Connection;
import java.sql.SQLException;

public class nosqlService implements dbManager {
    @Override
    public void connect(Connection connection) throws SQLException, ClassNotFoundException {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDb = mongoClient.getDatabase("test");
    }

    @Override
    public void createTable(Connection connection) throws SQLException {
        if(mongoDb.getCollection("employees") != null) {
            mongoDb.getCollection("employees").drop();
        }

        mongoDb.createCollection("employees");
    }

    @Override
    public void insertData(Connection connection) throws SQLException {
        Document employee1 = new Document().append("name", "Popescu Ion").
                append("address", "Bucharest").append("salary", 4000);

        MongoCollection<Document> collection = mongoDb.getCollection("employees");
        collection.insertOne(employee1);

        Document employee2 = new Document().append("name", "Ionescu Vasile").
                append("salary", 4500);
        collection.insertOne(employee2);
    }

    @Override
    public void readData(Connection connection) throws SQLException {
        FindIterable<Document> result = collection.find();
        for(Document doc : result) {
            System.out.println(doc);
        }
    }

    @Override
    public void disconnect(Connection connection) throws SQLException {
        mongoClient.close();
    }
}
