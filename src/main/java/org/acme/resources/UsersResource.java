package org.acme.resources;

import org.acme.bom.User;
import org.acme.services.UserService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    UserService userService;

    @GET
    public List<User> findAllUsers(@PathParam String name) {
        return userService.getUsers();
    }

    @GET
    @Path("/{name}")
    public User findUserByName(@PathParam String name) {
        return userService.getUserByName(name);
    }

    @POST
    public User addUser(User user) {
        return userService.addUser(user);
    }
}