package org.weather.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.weather.model.StateRecord;
import org.weather.model.key.StateRecordId;
import org.weather.repository.StateRecordRepository;
import org.weather.repository.StateRecordRepository;

import java.util.List;

@Path("state-records")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StateRecordResource {

    @Inject
    StateRecordRepository stateRecordRepository;


    @GET
    public Response getBy(@QueryParam("stateId")Long stateId, @QueryParam("year") Long year){
        if (stateId!=null&&year!=null){
            StateRecord cur=stateRecordRepository.findById(new StateRecordId(stateId,year));
            return Response.ok(cur).build();
        }else if (year!=null){
            List<StateRecord> cur=stateRecordRepository.findByYear(year);
            return Response.ok(cur).build();

        }else if (stateId!=null){
            List<StateRecord> cur=stateRecordRepository.findByCityId(stateId);
            return Response.ok(cur).build();
        }else{
            return Response.ok(stateRecordRepository.listAll()).build();
        }
    }
}
