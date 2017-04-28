package com.toyotaproject.dao;

import com.toyotaproject.domain.Trip;

import java.util.List;

/**
 * Created by burakgungor on 10.03.2017.
 */
public interface tripRepository {
    public List<Trip> getAllTrip();
    public Trip findTripById(long id);
    public Trip save(Trip trip);
    public Trip update(long id, Trip trip);
    public long delete(long id);


}
