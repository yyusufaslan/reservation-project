package com.toyotaproject.domain;
import javax.persistence.*;

/**
 * Created by burakgungor on 10.03.2017.
 */
@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "id")
    @SequenceGenerator(name = "id", sequenceName = "id")
    @Column(name="id")
    private long id;



    @OneToOne //HER REZERVASYON BİR CUSTOMER'A SAHİPTİR..
    //burda neden column yok
    @JoinColumn
    private Customer customer;



    @OneToOne//HER REZERVASYON BİR TRİP'E SAHİPTİR..
    @JoinColumn
    private Trip trip;

    @Column(name="reservated")
    private boolean reservated;

    public Reservation()
    {

    }
    public Reservation(Customer customer, Trip trip, boolean reservated) {
        this.customer = customer;
        this.trip = trip;
        this.reservated = reservated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public boolean isReservated() {
        return reservated;
    }

    public void setReservated(boolean reservated) {
        this.reservated = reservated;
    }
}
