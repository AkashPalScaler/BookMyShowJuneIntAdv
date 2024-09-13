package com.example.BookMyShow.services;

import com.example.BookMyShow.models.*;
import com.example.BookMyShow.repositories.BookingRepository;
import com.example.BookMyShow.repositories.ShowRepository;
import com.example.BookMyShow.repositories.ShowSeatRepository;
import com.example.BookMyShow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    UserRepository userRepository;
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;
    BookingRepository bookingRepository;

    public Booking bookShow(Long userId, Long showId, List<Long> showSeatIds){

        // Fetch and check user from userId
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User doesn't exist");
        }
        User user = userOptional.get();

        // Fetch and check the show from showId
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new RuntimeException("Show doesn't exist");
        }
        Show show = showOptional.get();

        // ----------------- Transaction Starts -------------------
        // Fetch the showSeats from the showSeatIds
        // Check the showSeats are available or not?
        // If not: Throw an error
        // If available : we block the seats -> change the status of the show seat to blocked
        // Save the showSeats back to DB
        // ------------------ Transaction ends ---------------------
        List<ShowSeat> showSeats = reserveSeats(show, showSeatIds);

        // Home Work
        // Get the pricing of the show seats
        // Get all the showSeatType, loop through the showSeats, check the seatType
        // Get the price from the corresponding showSeatType and sum them up

        // Create a corresponding booking with the showSeats
        Booking booking = new Booking();
        booking.setBooking_date(new Date());
        booking.setBookingStatus(BookingStatus.INPROGRESS);
        booking.setShowSeatList(showSeats);
        booking.setShow(show);
        booking.setUser(user);
        booking.setAmount(1000);

        // Return the booking object
        return bookingRepository.save(booking);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    private List<ShowSeat> reserveSeats(Show show, List<Long> showSeatIds){
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

//        Check the showSeats are available or not? BOOKED/OUT OF SERVICE/BLOCKED
        for(ShowSeat showSeat : showSeats){
            checkSeatAvailability(showSeat);
        }

        // If available : we block the seats -> change the status of the show seat to blocked
        for(ShowSeat showSeat: showSeats){
            if(!showSeat.getShow().equals(show)){
                throw new RuntimeException("Booking multiple shows not allowed")
            }
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
            showSeat.setBlockedAt(new Date());
//            showSeatRepository.save(showSeat);
        }
        return showSeatRepository.saveAll(showSeats);
    }

    private void checkSeatAvailability(ShowSeat showSeat){
        if(!showSeat.getSeatStatus().equals(SeatStatus.AVAILABLE)){
            if(showSeat.getSeatStatus().equals(SeatStatus.BOOKED)){
                throw new RuntimeException("Seats are already booked");
            }
            if(showSeat.getSeatStatus().equals(SeatStatus.OUT_OF_SERVICE)){
                throw new RuntimeException("Seats are out of service");
            }
            if(showSeat.getSeatStatus().equals((SeatStatus.BLOCKED))){
                Long blockedDuration = Duration.between(new Date().toInstant(), showSeat.getBlockedAt().toInstant()).toMinutes();
                if(blockedDuration < 10){
                    throw  new RuntimeException("Seats are already blocked by someone else, please try sometime later");
                }
            }
        }
    }

}
