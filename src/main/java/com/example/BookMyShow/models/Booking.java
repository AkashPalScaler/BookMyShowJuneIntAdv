package com.example.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    private int amount;
    private Date booking_date;
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;
    //Booking M:1 User
    @ManyToOne
    private User user;
    //Booking 1:M ShowSeat
    @OneToMany
    private List<ShowSeat> showSeatList;
    // Booking 1:M Payment
    @OneToMany
    private List<Payment> payments;
    //Booking M:1 Show
    @ManyToOne
    private Show show;
}

//BookingStatus: id | value - not created by hibernate
//Booking: id | amount | booking_date | bookingStatus(0/1/2/3)/(SUCCESS, FAILURE)
