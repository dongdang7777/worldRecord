package org.weather.rest;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.weather.model.Country;
import org.weather.repository.CountryRepository;

@Path("/countries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CountryResource {

    @Inject
    CountryRepository countryRepository;


    @GET
    public Response listCountries(){
        return Response.ok(countryRepository.listAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getCountryById(@PathParam("id") Long id){
        Country cur=countryRepository.findById(id);
        return Response.ok(cur).build();
    }

    @GET
    @Path("/{id}/cities")
    public Response getCities(@PathParam("id")Long id){
        Country cur=countryRepository.findById(id);
        return Response.ok(cur.getCities()).build();
    }

    @GET
    @Path("/{id}/states")
    public Response getStates(@PathParam("id")Long id){
        Country cur=countryRepository.findById(id);
        return Response.ok(cur.getStates()).build();
    }

    @GET
    @Path("/{id}/records")
    public Response getRecords(@PathParam("id")Long id){
        Country cur=countryRepository.findById(id);
        return Response.ok(cur.getCountryRecords()).build();
    }


}
