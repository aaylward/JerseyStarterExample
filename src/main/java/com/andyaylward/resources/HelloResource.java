package com.andyaylward.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.lang.String;

@Path("hello")
@Produces(MediaType.TEXT_PLAIN)
public class HelloResource {

  @GET
  public String sayHi(@QueryParam("name") String name) {
    return "Hello " + name;
  }
}
