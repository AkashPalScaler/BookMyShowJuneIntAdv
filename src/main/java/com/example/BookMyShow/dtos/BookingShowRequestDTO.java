package com.example.BookMyShow.dtos;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class BookingShowRequestDTO {
    Long userId;
    Long showId;
    List<Long> showSeatIds;
}
