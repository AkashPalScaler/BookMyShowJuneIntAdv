package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String name;
    // Seat M:1 SeatType
    @ManyToOne
    private SeatType seatType;
    private int row;
    private int col;
}
