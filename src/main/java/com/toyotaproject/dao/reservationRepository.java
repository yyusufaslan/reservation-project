package com.toyotaproject.dao;

import com.toyotaproject.domain.Reservation;

import java.util.List;

/**
 * Created by burakgungor on 10.03.2017.
 */
public interface reservationRepository {

    public List<Reservation> getAllReservation();
    public Reservation getReservationById(long id);
    public Reservation save(Reservation reservation);
    public Reservation update(long id, Reservation reservation);



}
