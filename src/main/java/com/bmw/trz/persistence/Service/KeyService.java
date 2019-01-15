package com.bmw.trz.persistence.Service;


import com.bmw.trz.persistence.Controller.KeyController;
import com.bmw.trz.persistence.Model.Key;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("key")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class KeyService {

    @Inject
    KeyController keyController;

    @GET
    public List<Key> findAll(){
        return this.keyController.findAllKeys();
    }
}
