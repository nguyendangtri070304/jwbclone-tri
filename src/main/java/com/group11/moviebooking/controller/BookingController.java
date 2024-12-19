package com.group11.moviebooking.controller;

import com.group11.moviebooking.entity.CustomerEntity;
import com.group11.moviebooking.service.BookingService;
import com.group11.moviebooking.service.CustomerService;
import com.group11.moviebooking.service.MovieService;
import com.group11.moviebooking.service.SeatService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
public class BookingController {
    private final MovieService movieService;
    private BookingService bookingService;
    private CustomerService customerService;
    private SeatService seatService;

    public BookingController(BookingService bookingService, CustomerService customerService, SeatService seatService, MovieService movieService) {
        this.bookingService = bookingService;
        this.customerService = customerService;
        this.seatService = seatService;
        this.movieService = movieService;
    }

    public boolean createBooking(long customer_id, int showtime_id, int total_price){
        return bookingService.createBooking(customer_id, showtime_id, total_price);
    }

    @PostMapping("/booking")
    @ResponseBody
    public ModelAndView handleBooking(@RequestBody Map<String, String> payload, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("/ticket-booking");
        String name = payload.get("name");
        String phone = payload.get("phone");
        String email = payload.get("email");

        // Lấy thông tin ghế đã chọn và các thông tin khác từ session
        List<Map<String, Object>> selectedSeats = (List<Map<String, Object>>) session.getAttribute("selectedSeats");
        Integer totalPrice = (Integer) session.getAttribute("totalPrice");
        Integer roomId = (Integer) session.getAttribute("room_id");
        Integer showtimeId = (Integer) session.getAttribute("showtime_id");
        String show_date = (String) session.getAttribute("show_date");
        String start_time = (String) session.getAttribute("start_time");
        int movie_id = (Integer) session.getAttribute("movie_id");
        String seats = (String) session.getAttribute("seats");

        String movie_title = movieService.getMovie(movie_id);
        session.setAttribute("movie_title", movie_title);

        CustomerEntity customer = customerService.getCustomerByEmail(email);


        // Lặp qua từng ghế đã chọn và tạo booking cho từng ghế
        for (Map<String, Object> seatData : selectedSeats) {
            String seatRow = String.valueOf(seatData.get("row"));
            String seatColumn = String.valueOf(seatData.get("column"));

            // Tạo một booking cho mỗi ghế
            boolean isBookingCreated = createBooking(customer.getCustomer_id(), showtimeId, totalPrice);

            //Tao booking_seatz
            int booking_id = bookingService.getLastBookingId();
            int seat_id = seatService.getSeatId(roomId, seatRow, seatColumn);
            boolean isBookingSeatCreated = bookingService.createBookingSeat(booking_id, seat_id);

        }

        modelAndView.addObject("movie_title", movie_title);
        modelAndView.addObject("totalPrice", totalPrice);
        modelAndView.addObject("seats", seats);
        modelAndView.addObject("show_date", show_date);
        modelAndView.addObject("start_time", start_time);

        System.out.println("Movie Title: " + movie_title);
        System.out.println("Seats: " + seats);
        System.out.println(show_date);
        System.out.println("Payload processed successfully."); // Log success
        return modelAndView;
    }
}
