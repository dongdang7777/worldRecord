package org.weather.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.weather.model.State;
import org.weather.repository.StateRepository;

@Path("/states")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StateResource {
    @Inject
    StateRepository stateRepository;


    @GET
    public Response listStates(){
        return Response.ok(stateRepository.listAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getStateById(@PathParam("id") Long id){
        State cur=stateRepository.findById(id);
        return Response.ok(cur).build();
    }

    @GET
    @Path("/{id}/records")
    public Response getRecords(@PathParam("id")Long id){
        State cur=stateRepository.findById(id);
        return Response.ok(cur.getStateRecords()).build();
    }


}
