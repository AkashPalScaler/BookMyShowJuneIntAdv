package com.example.BookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    Long userId;
    ResponseStatus responseStatus;
    String message;
}
