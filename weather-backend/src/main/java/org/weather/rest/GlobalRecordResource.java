package org.weather.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.weather.model.GlobalRecord;
import org.weather.model.Year;
import org.weather.repository.GlobalRecordRepository;
import org.weather.repository.YearRepository;

@Path("/global-records")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class GlobalRecordResource {
    @Inject
    GlobalRecordRepository globalRecordRepository;

    @Inject
    YearRepository yearRepository;


    @GET
    public Response getRecordByYear(@QueryParam("year") Long year){
        if (year==null){
            return Response.ok(globalRecordRepository.listAll()).build();
        }
        Year cur= yearRepository.findById(year);
        return Response.ok(cur.getGlobalRecord()).build();
    }

    @GET
    @Path("/{id}")
    public Response getRecordById(@PathParam("id")Long id){
        GlobalRecord cur=globalRecordRepository.findById(id);
        return Response.ok(cur).build();
    }



}
