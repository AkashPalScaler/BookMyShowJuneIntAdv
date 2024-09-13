package com.example.BookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {
    Long userId;
    ResponseStatus responseStatus;
    String message;
}
