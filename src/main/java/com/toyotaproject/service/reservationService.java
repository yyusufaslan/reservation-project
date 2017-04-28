package com.toyotaproject.service;

import com.toyotaproject.domain.Reservation;

import java.util.List;

/**
 * Created by burakgungor on 10.03.2017.
 */
public interface reservationService {
    public List<Reservation> getAllReservation();
    public Reservation saveReservation(Reservation reservation);
    public Reservation getReservationById(long id);
    public Reservation updateReservation(long id, Reservation reservation);



}
