package com.example.BookMyShow.repositories;

import com.example.BookMyShow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
