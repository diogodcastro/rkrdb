package com.bmw.trz.persistence;

import com.mongodb.MongoClient;

import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;

@Singleton
public class MongoConnection {
    @Produces
    @ApplicationScoped
    public MongoClient mongoClient() {
       return new MongoClient("localhost", 27017);
    }

}
