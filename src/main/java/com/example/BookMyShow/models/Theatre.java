package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    private String address;
//    private List<Screen> screens; - no use case
    // Theatre M:M Movie
    @ManyToMany
    private List<Movie> movies;
}

// findAllScreenByTheatreID (id){
// select * from screen where theatre_id=id
//}