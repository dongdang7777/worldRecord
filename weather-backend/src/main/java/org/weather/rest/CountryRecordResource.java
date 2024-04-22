package org.weather.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.weather.model.CountryRecord;
import org.weather.model.key.CountryRecordId;
import org.weather.repository.CountryRecordRepository;
import org.weather.repository.CountryRecordRepository;

import java.util.List;

@Path("country-records")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CountryRecordResource {

    @Inject
    CountryRecordRepository countryRecordRepository;


    @GET
    public Response getBy(@QueryParam("countryId")Long countryId, @QueryParam("year") Long year){
        if (countryId!=null&&year!=null){
            CountryRecord cur=countryRecordRepository.findById(new CountryRecordId(countryId,year));
            return Response.ok(cur).build();
        }else if (year!=null){
            List<CountryRecord> cur=countryRecordRepository.findByYear(year);
            return Response.ok(cur).build();

        }else if (countryId!=null){
            List<CountryRecord> cur=countryRecordRepository.findByCityId(countryId);
            return Response.ok(cur).build();
        }else{
            return Response.ok(countryRecordRepository.listAll()).build();
        }
    }
}
