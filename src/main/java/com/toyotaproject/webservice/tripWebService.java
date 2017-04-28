package com.toyotaproject.webservice;

import com.toyotaproject.domain.Trip;
import com.toyotaproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by yusufaslan on 5.04.2017.
 */
@Component("tripWebService")
@Path("/trip")
@Produces("application/json")
public class tripWebService {
    @Autowired
    private tripService tripService;


    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Trip findTripById(@PathParam("id") long id)
    {

        return  tripService.findTripById(id);
    }

    @GET
    @Path("/trips")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trip> getAllTrip()
    {

        return tripService.getAllTrip();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Trip saveTrip(Trip trip)
    {

        return tripService.save(trip);
    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Trip updateTrip(@PathParam("id")long id , Trip trip)
    {

        return tripService.update(id, trip);
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public long deleteTrip(@PathParam("id")long id)
    {
        return tripService.delete(id);
    }
}
