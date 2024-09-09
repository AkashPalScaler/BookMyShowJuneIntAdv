package com.example.BookMyShow.models;

import java.util.List;

public class Screen extends BaseModel{
    private String name;
    private List<Feature> features;
    private List<Seat> seats;
    private Theatre theatre;
    //list of movie/show can also be added here
}
