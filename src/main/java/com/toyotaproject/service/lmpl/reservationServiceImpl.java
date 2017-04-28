package com.toyotaproject.service.lmpl;

import com.toyotaproject.dao.*;
import com.toyotaproject.domain.*;
import com.toyotaproject.domain.Customer;
import com.toyotaproject.domain.Reservation;
import com.toyotaproject.service.reservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by burakgungor on 10.03.2017.
 */
@Service
public class reservationServiceImpl implements reservationService {

    @Autowired
    private reservationRepository reservationRepository;
    @Autowired
    private customerRepository customerRepository;
    @Autowired
    private tripRepository tripRepository;

    @Transactional
    @Override
    public List<Reservation> getAllReservation() {
        List<Reservation> reservations = new ArrayList<Reservation>();
        for (Reservation reservation : reservationRepository.getAllReservation())
            reservations.add(reservation);
        return reservations;
    }

    @Transactional
    @Override
    public Reservation saveReservation(Reservation reservation) {
        final Customer dbCustomer =customerRepository.getCustomerByUserName(reservation.getCustomer().getUserName()
        );

        if (dbCustomer==null)
            customerRepository.save(reservation.getCustomer());
        final Trip trip=tripRepository.findTripById(1);

        reservation.setTrip(trip);
        //reservation.setTrip(rs);
        return reservation;
    }

    @Transactional
    @Override
    public Reservation getReservationById(long id) {
        Reservation reservation=reservationRepository.getReservationById(id);
        return reservation;
    }

    @Override
    public Reservation updateReservation(long id, Reservation reservation) {
        return reservationRepository.update(id, reservation);
    }
}
