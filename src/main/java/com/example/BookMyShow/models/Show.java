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
@Entity( name = "bms_show")
public class Show extends BaseModel{
    private Date start_time;
    // SHow M:1 Movie
    @ManyToOne
    private Movie movie;
    //Show M:1 Theatre
    @ManyToOne
    private Theatre theatre;
    //Show M:1 Screen
    @ManyToOne
    private Screen screen;
    // Show 1:M ShowSeat
    @OneToMany
    private List<ShowSeat> showSeatList;
    //Show : ShowSeatType
    @OneToMany
    private List<ShowSeatType> showSeatTypeList;

}

//show show_seat status
//1        1_A     booked
//1        1_B     booked
//2        2_A     booked
//2        2_B     booked

//show show_seatType price
//1        1_GOLD     100
//1        1_SILVER     50
//2        2_GOLD     400
//2        2_SILVER     200


// Show : seat (M:M)
// Show: seatType (M:M)
// Show : show_seatType