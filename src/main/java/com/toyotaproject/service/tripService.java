package com.toyotaproject.service;

import com.toyotaproject.domain.Trip;

import java.util.List;

/**
 * Created by yusufaslan on 3.04.2017.
 */
public interface tripService {
    public List<Trip> getAllTrip();
    public Trip findTripById(long id);
    public Trip save(Trip trip);
    public Trip update(long id, Trip trip);
    public long delete(long id);

}
