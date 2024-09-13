package com.example.BookMyShow.repositories;

import com.example.BookMyShow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
