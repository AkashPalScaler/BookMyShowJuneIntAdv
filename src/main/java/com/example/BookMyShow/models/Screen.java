package com.example.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;
    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<Feature> features;
    // Screen 1:M Seat
    @OneToMany
    private List<Seat> seats;
    // screen M:1 Theatre
    @ManyToOne
    private Theatre theatre;
    //list of movie/show can also be added here
}
