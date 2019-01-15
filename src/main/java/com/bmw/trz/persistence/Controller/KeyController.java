package com.bmw.trz.persistence.Controller;


import com.bmw.trz.persistence.Model.Key;
import com.bmw.trz.persistence.MongoConnection;
import com.bmw.trz.persistence.Service.KeyService;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class KeyController {

    public static final String DB_NAME = "rkrdb";
    public static final String COLL_NAME = "keys";

    protected MongoDatabase db;
    protected MongoCollection<Document> coll;

    @Inject
    MongoClient mongoClient;

    @PostConstruct
    public void init() {
        this.db = this.mongoClient.getDatabase(DB_NAME);
        this.coll = this.db.getCollection(COLL_NAME);
    }

    public List<Key> findAllKeys() {
        List<Key> keys = new ArrayList<>();
        MongoCursor<Document> cursor = this.coll.find().iterator();

        try{
            while(cursor.hasNext()){
                Document keyBson = cursor.next();
                Key key = new Key();
                //String objectId = keyBson.getObjectId("_id").toString();
                key.setVin(keyBson.getString("vin"));
                key.setRawData(keyBson.getString("rawData"));
                key.setTimeStamp(keyBson.getString("timeStamp"));
                keys.add(key);
            }
        }
        finally {
            cursor.close();
        }
        return keys;
    }


}
