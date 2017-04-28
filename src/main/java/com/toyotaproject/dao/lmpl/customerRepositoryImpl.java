package com.toyotaproject.dao.lmpl;

import com.toyotaproject.dao.customerRepository;
import com.toyotaproject.domain.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by burakgungor on 10.03.2017.
 */
@Repository
public class customerRepositoryImpl implements customerRepository {
    @PersistenceContext(unitName = "toyotaproject")
    private EntityManager entityManager;
    @Transactional
    @Override
    public Customer getCustomerByUserName(String userName) {
         Customer result=null;
        try{
            result=(Customer)entityManager.createQuery( "SELECT Customer FROM Customer c WHERE c.userName=:userName")
                    .setParameter("userName",userName).getSingleResult();
        }catch (final NoResultException e){
        }
        return result;
    }

    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> customers=new ArrayList<Customer>();
        customers.add((Customer) entityManager.createQuery("SELECT Customer FROM Customer i order by i.id").getResultList());
        return customers;
    }

    @Override
    public Customer getCustomerById(long id) {

        Customer result=null;
        try{
            result=(Customer)entityManager.createQuery( "SELECT Customer FROM Customer c WHERE c.id=:id")
                    .setParameter("id",id).getSingleResult();
        }catch (final NoResultException e){
        }
        return result;
    }

    @Override
    public Customer save(final Customer customer)
    {
        entityManager.persist(customer);
        return customer;
    }

    @Override
    public Customer update(long id,Customer customer)
    {
        return entityManager.merge(customer);
    }

    @Override
    public long delete(long id)
    {
        entityManager.remove(id);
      return  id;
    }
}
