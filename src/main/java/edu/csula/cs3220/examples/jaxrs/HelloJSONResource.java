package edu.csula.cs3220.examples.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.csula.cs3220.examples.jaxrs.models.User;

@Path("hello-json-resource")
@Singleton // used to keep resource between requests otherwise request cope
public class HelloJSONResource {
    private List<User> users = new ArrayList<>(Arrays.asList(new User("Eric", "Liao")));

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello() {
        return "Hello, JAX-RS";
    }

    @GET
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUser() {
        return users;
    }

    @POST
    @Path("users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addUser(User newUser) {
        System.out.println(newUser);
        users.add(newUser);
        System.out.println(users);
        return true;
    }
}
