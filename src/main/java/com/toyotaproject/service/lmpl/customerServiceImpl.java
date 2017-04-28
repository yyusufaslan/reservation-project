package com.toyotaproject.service.lmpl;

import com.toyotaproject.dao.*;
import com.toyotaproject.domain.Customer;
import com.toyotaproject.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yusufaslan on 3.04.2017.
 */
@Service
public class customerServiceImpl implements customerService {

    @Autowired
    private customerRepository customerRepository;


    @Transactional
    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<Customer>();
            for (Customer customer : customerRepository.findAllCustomer())
                customers.add(customer);
            return customers;
    }
    @Transactional
    @Override
    public Customer getCustomerByUserName(String userName){
        Customer customer;
        customer = customerRepository.getCustomerByUserName(userName);

        return customer;
    }

    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        customerRepository.save(customer);
        return customer;
    }

    @Transactional
    @Override
    public Customer getCustomerById(long id) {
       Customer customer;
        customer = customerRepository.getCustomerById(id);

        return customer;
    }

    @Transactional
    @Override
    public Customer update(long id,Customer customer)
    {
        customerRepository.update(id,customer);
        return customer;
    }

    @Transactional
    @Override
    public long delete(long id)
    {
        customerRepository.delete(id);
        return id;
    }
}
