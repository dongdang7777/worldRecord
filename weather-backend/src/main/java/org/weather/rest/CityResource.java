package org.weather.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.weather.model.City;
import org.weather.model.State;
import org.weather.repository.CityRepository;
import org.weather.repository.StateRepository;

@Path("/cities")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CityResource {
    @Inject
    CityRepository cityRepository;


    @GET
    public Response listCities(){
        return Response.ok(cityRepository.listAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getStateById(@PathParam("id") Long id){
        City cur=cityRepository.findById(id);
        return Response.ok(cur).build();
    }

    @GET
    @Path("/{id}/records")
    public Response getRecords(@PathParam("id")Long id){
        City cur=cityRepository.findById(id);
        return Response.ok(cur.getCityRecords()).build();
    }






}
