package com.example.BookMyShow.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private String genre;
    private int run_time;
    @ElementCollection
    private List<String> actors;
    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<Language> languages;
}

// Movie_actor : movie_id | actor_name
//                    1     | SRK
//`                   1     | DEEPIKA
//`                   2     | SALMAN
