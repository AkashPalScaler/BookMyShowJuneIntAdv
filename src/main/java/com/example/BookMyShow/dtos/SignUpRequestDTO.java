package com.example.BookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDTO {
    String name;
    String email;
    String password;
}
