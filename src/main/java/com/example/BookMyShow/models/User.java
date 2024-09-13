package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Getter
@Setter
@Entity(name = "bms_user")
public class User extends BaseModel{
    private String name;
    private String email;
    // User 1:M Booking
    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;
    private String password;
}
