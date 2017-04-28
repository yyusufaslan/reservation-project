package com.toyotaproject.webservice;

import com.toyotaproject.domain.Customer;
import com.toyotaproject.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by yusufaslan on 5.04.2017.
 */
@Component("customerWebService")
@Path("/customer")
@Produces("application/json")
public class customerWebService {

    @Autowired
    private customerService customerService;



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userName}")
    public Customer getCustomerByUserName(@PathParam("userName")String userName)
    {

        return customerService.getCustomerByUserName(userName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update/{userid}")
    public Customer getCustomerById(@PathParam("userid")long id)
    {

        return customerService.getCustomerById(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/{userid}")
    public Customer updateCustomer(@PathParam("userid")long id,Customer customer){

        return customerService.update(id,customer);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Customer saveCustomer(Customer customer)
    {

        return customerService.save(customer);
    }
    @GET
    @Path("/customers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomer()
    {
        return customerService.getAllCustomer();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{userid}")
    public long deleteCustomer(@PathParam("userid")long id)
    {
        return customerService.delete(id);
    }







}
