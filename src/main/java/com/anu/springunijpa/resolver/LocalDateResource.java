package com.anu.springunijpa.resolver;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Path("User")
public class LocalDateResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser() {
        User user = new User();
        user.dOB = LocalDate.now();
        return Response.ok(user).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        return Response.ok(
                DateTimeFormatter.ISO_DATE.format(user.dOB)).build();
    }

    public static class User {
        public LocalDate dOB;
    }

}
