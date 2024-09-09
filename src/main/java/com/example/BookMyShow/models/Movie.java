package com.example.BookMyShow.models;

import java.util.List;

public class Movie extends BaseModel{
    private String name;
    private String genre;
    private int run_time;
    private List<String> actors;
    private List<Language> languages;
}
