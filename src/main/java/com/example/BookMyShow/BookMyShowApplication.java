package com.example.BookMyShow;

import com.example.BookMyShow.controllers.BookingController;
import com.example.BookMyShow.controllers.UserController;
import com.example.BookMyShow.dtos.*;
import com.example.BookMyShow.models.*;
import com.example.BookMyShow.repositories.MovieRepository;
import com.example.BookMyShow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

	@Autowired
	UserController userController;
	BookingController bookingController;
	MovieRepository movieRepository;

	public void dataGeneration(){

		List<Movie> movies = new ArrayList<>();
		Movie movie1 = new Movie();
		movie1.setName("Kalki");

		Movie movie2 = new Movie();
		movie2.setName("Dunki");

		Movie movie3 = new Movie();
		movie3.setName("Deadpool");

		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);

		//Save all the movies
		movieRepository.saveAll(movies);

		SeatType seatType1 = new SeatType();
		seatType1.setType("GOLD");
		SeatType seatType2 = new SeatType();
		seatType2.setType("SILVER");


		List<Theatre> theatres = new ArrayList<>();
		Theatre theatre1 = new Theatre();
		theatre1.setName("Cinemax");
		theatre1.setAddress("Thane");
		theatre1.setMovies(movies);

		List<Seat> seats1 = new ArrayList<>(); //Screen 1
		List<Seat> seats2 = new ArrayList<>(); // Screen 2
		Seat seat1 = new Seat();
		seat1.setName("1A");
		seat1.setSeatType(seatType1);
		Seat seat2 = new Seat();
		seat2.setName("2B");
		seat2.setSeatType(seatType1);

		seats1.add(seat1);
		seats1.add(seat2);

		Seat seat3 = new Seat();
		seat3.setName("1A");
		seat3.setSeatType(seatType1);
		Seat seat4 = new Seat();
		seat4.setName("2B");
		seat4.setSeatType(seatType1);

		seats2.add(seat3);
		seats2.add(seat4);

		Screen screen1 = new Screen();
		screen1.setName("AUDI 1");
		screen1.setTheatre(theatre1);
		screen1.setSeats(seats1);

		Screen screen2 = new Screen();
		screen2.setName("AUDI 2");
		screen2.setTheatre(theatre1);
		screen2.setSeats(seats2);


		Theatre theatre2 = new Theatre();
		theatre2.setName("IMAX");
		theatre2.setAddress("Kolshet Rd");
		theatre2.setMovies(movies);

		List<Seat> seats3 = new ArrayList<>(); // Screen 3
		List<Seat> seats4 = new ArrayList<>(); //Screen 4
		Seat seat31 = new Seat();
		seat31.setName("1A");
		seat31.setSeatType(seatType1);
		Seat seat32 = new Seat();
		seat32.setName("2B");
		seat32.setSeatType(seatType1);

		seats3.add(seat31);
		seats3.add(seat32);

		Seat seat41 = new Seat();
		seat41.setName("1A");
		seat41.setSeatType(seatType1);
		Seat seat42 = new Seat();
		seat42.setName("2B");
		seat42.setSeatType(seatType1);

		seats4.add(seat41);
		seats4.add(seat42);

		Screen screen3 = new Screen();
		screen3.setName("SCREEN 1");
		screen3.setTheatre(theatre2);
		screen3.setSeats(seats3);

		Screen screen4 = new Screen();
		screen4.setName("SCREEN 2");
		screen4.setTheatre(theatre2);
		screen4.setSeats(seats4);

		theatres.add(theatre1);
		theatres.add(theatre2);

		Region region = new Region();
		region.setName("Mumbai");
		region.setTheatres(theatres);

		// Home work : Add all repos
		//Create show for each screen in each theatre
		//Create showSeat for each of those shows
	}

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		SignUpRequestDTO requestDTO = new SignUpRequestDTO();
//		requestDTO.setEmail("akash.pal3@gmail.com");
//		requestDTO.setName("Akash");
//		requestDTO.setPassword("passpass");
//
//		SignUpResponseDTO responseDTO = userController.signup(requestDTO);
//		System.out.println(responseDTO.getMessage());

		LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
		loginRequestDTO.setEmail("akash.pal3@gmail.com");
		loginRequestDTO.setPassword("passpass1");

		LoginResponseDTO loginResponseDTO = userController.login(loginRequestDTO);
		System.out.println(loginResponseDTO.getMessage());

		dataGeneration();

		BookingShowRequestDTO requestDTO = new BookingShowRequestDTO();
		requestDTO.setUserId(loginResponseDTO.getUserId());
//		requestDTO.setShowId();
//		requestDTO.setShowSeatIds();

		BookingShowResponseDTO responseDTO = bookingController.bookShow(
				requestDTO
		);

	}
}
