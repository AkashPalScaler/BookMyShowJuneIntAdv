package com.example.BookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingShowResponseDTO {
    Long bookingId;
    int price;
    ResponseStatus responseStatus;
    String message;
}
