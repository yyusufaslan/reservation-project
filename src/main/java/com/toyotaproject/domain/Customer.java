package com.toyotaproject.domain;


import javax.persistence.*;

/**
 * Created by burakgungor on 10.03.2017.
 */
@Entity
@Table(name="customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "id")
    @SequenceGenerator(name = "id", sequenceName = "id")
    @Column(name="id")
    private long id;

    @Column(name="userName",unique = true,length = 10)
    private String userName;

    @Column(name="email",nullable = false,length = 30)
    private String email;

    @Column(name="role")
    private String role;

    @Column(name="name",nullable = false,length = 30)
    private String name;

    @Column(name="lastName",nullable = false,length = 30)
    private String lastName;

    @Column(name="password",nullable = false,length = 30)
    private String password;

    private boolean status;


    public Customer(){

    }

    public Customer(String userName, String name, String lastName, String password) {
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
