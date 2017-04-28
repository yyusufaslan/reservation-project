package com.toyotaproject.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by burakgungor on 10.03.2017.
 */
@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "id")
    @SequenceGenerator(name = "id", sequenceName = "id")
    @Column(name="id")
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name="date")
    private Date date;


    @Column(name="place",nullable = false)
    private String place;


    @Column(name="purpose",nullable = false)
    private String purpose;


    @Column(name="price",nullable = false)
    private double price;


    @Column(name = "department",nullable = false)
    private String department;


    @Column(name = "projectCode",nullable = false)
    private String projectCode;


    @Column(name = "director",nullable = false)
    private String director;

    public Trip()
    {

    }
    public Trip(Date date, String place, String purpose, double price, String department, String projectCode, String director) {
        this.date = date;
        this.place = place;
        this.purpose = purpose;
        this.price = price;
        this.department = department;
        this.projectCode = projectCode;
        this.director = director;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
