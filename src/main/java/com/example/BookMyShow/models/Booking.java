package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
