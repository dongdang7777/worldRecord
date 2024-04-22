package org.weather.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.weather.model.CityRecord;
import org.weather.model.key.CityRecordId;
import org.weather.repository.CityRecordRepository;
import org.weather.repository.CityRepository;
import org.weather.service.CityRecordService;

import java.util.List;

@Path("/city-records")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class CityRecordResource {
    @Inject
    CityRecordRepository cityRecordRepository;

    @Inject
    CityRecordService cityRecordService;

    @GET
    public Response getBy(@QueryParam("cityId")Long cityId,@QueryParam("year") Long year){
        if (cityId!=null&&year!=null){
            CityRecord cur=cityRecordRepository.findById(new CityRecordId(cityId,year));
            return Response.ok(cur).build();
        }else if (year!=null){
            List<CityRecord> cur=cityRecordRepository.findByYear(year);
            return Response.ok(cur).build();

        }else if (cityId!=null){
            List<CityRecord> cur=cityRecordRepository.findByCityId(cityId);
            return Response.ok(cur).build();
        }else{
            return Response.ok(cityRecordRepository.listAll()).build();
        }
    }

    @GET
    @Path("{cityId}/periods/{periodLength}/{startYear}")
    public Response getPeriodByCityId(@PathParam("cityId") Long cityId,@PathParam("startYear") Long startYear,@PathParam("periodLength") Long length){
        return Response.ok(cityRecordRepository.getPeriodByCityId(cityId,startYear,length)).build();
    }

    @GET
    @Path("/periods/{periodLength}")
    public Response getAllPeriods(@PathParam("periodLength") Long length){
        return Response.ok(cityRecordService.getAllPeriods(length)).build();
    }


}
