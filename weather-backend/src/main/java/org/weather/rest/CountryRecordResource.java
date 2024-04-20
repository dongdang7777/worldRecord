package org.weather.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.weather.model.CountryRecord;
import org.weather.repository.CountryRecordRepository;

import java.util.List;

@Path("country")
@Produces(MediaType.APPLICATION_JSON)
public class CountryRecordResource {

    @Inject
    CountryRecordRepository repo;

    @GET
    @Path("test")
    public List<CountryRecord> test(){
        return  repo.listAll();
    }
}
