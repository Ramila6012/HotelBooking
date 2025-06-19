package com.springboot.hotelbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Customer {

    @Id
    private int id;
    private String name;
    private int room_no;
    private Date checkin_date;
    private Date checkout_date;

    public Customer(){
        super();
    }

    public Customer(int id, String name, int room_no, Date checkin_date, Date checkout_date) {
        this.id = id;
        this.name = name;
        this.room_no = room_no;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoom_no() {
        return room_no;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }

    public Date getCheckin_date() {
        return checkin_date;
    }

    public void setCheckin_date(Date checkin_date) {
        this.checkin_date = checkin_date;
    }

    public Date getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(Date checkout_date) {
        this.checkout_date = checkout_date;
    }
}
