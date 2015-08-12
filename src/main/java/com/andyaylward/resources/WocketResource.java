package com.andyaylward.resources;

import com.andyaylward.data.Wocket;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("gimme-json")
@Produces(MediaType.APPLICATION_JSON)
public class WocketResource {

  @GET
  public Wocket getThing(@QueryParam("name") String name) {
    return new Wocket(name);
  }
}
