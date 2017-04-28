package com.toyotaproject.service;

import com.toyotaproject.domain.Customer;

import java.util.List;

/**
 * Created by yusufaslan on 3.04.2017.
 */
public interface customerService {

    public List<Customer> getAllCustomer();
    public Customer getCustomerByUserName(String userName);
    public Customer save(Customer customer);
    public Customer getCustomerById(long id);
    public Customer update(long id, Customer customer);
    public long delete(long id);



}
