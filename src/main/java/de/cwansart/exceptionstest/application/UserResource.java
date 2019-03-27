package de.cwansart.exceptionstest.application;

import de.cwansart.exceptionstest.domain.UserRepository;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("users")
@Produces("application/json")
public class UserResource {
    @Inject
    private UserRepository repository;

    @GET
    public Response getUsers() {
        return Response.ok(repository.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getUserById(@PathParam("id") Long id) {
        try {
            return Response.ok(repository.getById(id)).build();
        } catch (NoResultException e) {
            return Response.status(404).build();
        }
    }
}
