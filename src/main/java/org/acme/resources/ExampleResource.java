package org.acme.resources;

import org.acme.services.ExampleService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExampleResource {

    @Inject
    ExampleService exampleService;

    @GET
    @Path("/{name}")
    public String hello(@PathParam String name) {
        return exampleService.hello(name);
    }
}