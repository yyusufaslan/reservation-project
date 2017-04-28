package com.toyotaproject.dao;

import com.toyotaproject.domain.Customer;

import java.util.List;

/**
 * Created by burakgungor on 10.03.2017.
 */
public interface customerRepository {

    public Customer getCustomerByUserName(String userName);
    public List<Customer> findAllCustomer();
    public Customer getCustomerById(long id);
    public Customer save(Customer customer);

    public Customer update(long id, Customer customer);

    public long delete(long id);

}
