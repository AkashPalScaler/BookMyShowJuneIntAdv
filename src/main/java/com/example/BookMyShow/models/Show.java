package com.example.BookMyShow.models;

import java.util.Date;
import java.util.List;

public class Show extends BaseModel{
    private Date start_time;
    private Movie movie;
    private Theatre theatre;
    private Screen screen;
    private List<ShowSeat> showSeatList;
    private List<ShowSeatType> showSeatTypeList;

}
