package com.stackroute.mongodemo;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Date;

public class MongoOperation {
    MongoClient mongoClient = new MongoClient("localhost", 27017);
    DB db = mongoClient.getDB("testDB");
    DBCollection dbCollection = db.getCollection("user");
    public MongoOperation() throws UnknownHostException{

    }

    public void createDocument(){
        BasicDBObject document = new BasicDBObject();
        document.put("name","markus");
        document.put("age",24);
        document.put("createDate",new Date());
        dbCollection.insert(document);
        // find and display
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("age",24);
        DBCursor cursor = dbCollection.find(searchQuery);

        while (cursor.hasNext()){
            System.out.println("inserted documents " + cursor.next());
        }
    }
    //update
    public void updateDocument(){
        BasicDBObject query = new BasicDBObject();
        query.put("age",24);
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("age",25);
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set",newDocument);
        dbCollection.update(query,updateObject);
        //find and display
        BasicDBObject searchQuery2 = new BasicDBObject().append("age",25);
        DBCursor cursor2 = dbCollection.find(searchQuery2);
        while (cursor2.hasNext()){
            System.out.println("updated document: " + cursor2.next());
        }

    }
    public void deleteDocument(){
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("age",25);
        dbCollection.remove(searchQuery);
        System.out.println("Deleted!!");
    }
}
