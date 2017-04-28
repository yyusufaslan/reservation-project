package com.toyotaproject.webservice;

import com.toyotaproject.domain.*;
import com.toyotaproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by yusufaslan on 3.04.2017.
 */
@Component("reservationWebService")
@Path("/reservation/")
@Produces("application/json")
public class reservationWebService {

    @Autowired
    private reservationService reservationService;


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reservation getReservationById(@PathParam("id") long id)
    {

        return  reservationService.getReservationById(id);
    }
    @GET
    @Path("/reservations")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reservation> getAllReservation()
    {

        return reservationService.getAllReservation();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Reservation saveReservation(Reservation reservation)
    {

        return reservationService.saveReservation(reservation);
    }

    @PUT
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Reservation updateReservation(@PathParam("id")long id , Reservation reservation)
    {

        return reservationService.updateReservation(id, reservation);
    }




}
