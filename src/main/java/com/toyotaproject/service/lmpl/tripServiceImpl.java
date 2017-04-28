package com.toyotaproject.service.lmpl;

import com.toyotaproject.dao.*;
import com.toyotaproject.domain.*;
import com.toyotaproject.service.tripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yusufaslan on 3.04.2017.
 */
@Service
public class tripServiceImpl implements tripService {


    @Autowired
    private tripRepository tripRepository;


    @Override
    public List<Trip> getAllTrip() {
            List<Trip> trips = new ArrayList<Trip>();
            for (Trip trip : tripRepository.getAllTrip())
                trips.add(trip);
            return trips;
    }

    @Transactional
    @Override
    public Trip findTripById(long id) {

        Trip trip;
        trip = tripRepository.findTripById(id);

        return trip;
    }

    @Transactional
    @Override
    public Trip save(Trip trip) {
        tripRepository.save(trip);
        return trip;
    }

    @Transactional
    @Override
    public Trip update(long id,Trip trip) {
        tripRepository.update(id,trip);
        return trip;
    }

    @Transactional
    @Override
    public long delete(long id)
    {
        tripRepository.delete(id);
        return id;
    }
}
