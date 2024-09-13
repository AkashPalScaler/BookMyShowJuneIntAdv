package com.example.BookMyShow.controllers;

import com.example.BookMyShow.dtos.BookingShowRequestDTO;
import com.example.BookMyShow.dtos.BookingShowResponseDTO;
import com.example.BookMyShow.dtos.ResponseStatus;
import com.example.BookMyShow.models.Booking;
import com.example.BookMyShow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;

    public BookingShowResponseDTO bookShow(BookingShowRequestDTO bookingShowRequestDTO){
        BookingShowResponseDTO responseDTO = new BookingShowResponseDTO();

        try{
            Booking booking = bookingService.bookShow(
                    bookingShowRequestDTO.getUserId(),
                    bookingShowRequestDTO.getShowId(),
                    bookingShowRequestDTO.getShowSeatIds()
            );

            responseDTO.setBookingId(booking.getId());
            responseDTO.setPrice(booking.getAmount());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("Booking is on hold, please go for payment");

        }catch(Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("Booking failed");
        }

        return responseDTO;
    }
}
