package com.example.BookMyShow.models;

import java.util.List;

public class Theatre extends BaseModel{
    private String name;
    private String address;
//    private List<Screen> screens; - no use case
    private List<Movie> movies;
}

// findAllScreenByTheatreID (id){
// select * from screen where theatre_id=id
//}