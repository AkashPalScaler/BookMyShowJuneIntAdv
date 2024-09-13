package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    // ShowSeat M:1 show
    @ManyToOne
    private Show show;
    // ShowSeat M:1 seat
    @ManyToOne
    private  Seat seat; // seatType
    @Enumerated(value = EnumType.STRING)
    private SeatStatus seatStatus;
    private Date blockedAt;
}
