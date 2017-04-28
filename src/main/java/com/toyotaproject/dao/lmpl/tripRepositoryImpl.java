package com.toyotaproject.dao.lmpl;

import com.toyotaproject.dao.tripRepository;
import com.toyotaproject.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by burakgungor on 10.03.2017.
 */

@Repository
public class tripRepositoryImpl implements tripRepository {



    @PersistenceContext(unitName = "toyotaproject")
    private EntityManager entityManager;


    @Override
    public List<Trip> getAllTrip() {
        List<Trip> trips=new ArrayList<Trip>();
        trips.add((Trip) entityManager.createQuery("SELECT Customer FROM Customer i order by i.id").getResultList());
        return trips;
    }

    public Trip findTripById(long id) {
        return entityManager.find(Trip.class,id);
    }

    @Override
    public Trip save(Trip trip) {
       entityManager.persist(trip);
        return trip;
    }

    @Override
    public Trip update(long id, Trip trip) {
       return entityManager.merge(trip);
    }

    @Override
    public long delete(long id) {
        entityManager.remove(id);
        return id;
    }

}
