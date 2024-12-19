package com.group11.moviebooking.controller;

import com.group11.moviebooking.entity.CustomerEntity;
import com.group11.moviebooking.service.BookingService;
import com.group11.moviebooking.service.CustomerService;
import com.group11.moviebooking.service.SeatService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class BookingController {
    private BookingService bookingService;
    private CustomerService customerService;
    private SeatService seatService;

    public BookingController(BookingService bookingService, CustomerService customerService, SeatService seatService) {
        this.bookingService = bookingService;
        this.customerService = customerService;
        this.seatService = seatService;
    }

    public boolean createBooking(long customer_id, int showtime_id, int total_price){
        return bookingService.createBooking(customer_id, showtime_id, total_price);
    }

    @PostMapping("/booking")
    @ResponseBody
    public ResponseEntity<String> handleBooking(@RequestBody Map<String, String> payload, HttpSession session) {
        String name = payload.get("name");
        String phone = payload.get("phone");
        String email = payload.get("email");

        // Kiểm tra các trường bắt buộc
        if (name == null || phone == null || email == null) {
            return ResponseEntity.badRequest().body("All fields are required.");
        }
        // Lấy thông tin ghế đã chọn và các thông tin khác từ session
        List<Map<String, Object>> selectedSeats = (List<Map<String, Object>>) session.getAttribute("selectedSeats");
        Integer totalPrice = (Integer) session.getAttribute("totalPrice");
        Integer roomId = (Integer) session.getAttribute("room_id");
        Integer showtimeId = (Integer) session.getAttribute("showtime_id");

        CustomerEntity customer = customerService.getCustomerByEmail(email);
        if (customer == null) {
            return ResponseEntity.badRequest().body("Customer not found.");
        }

        // Kiểm tra nếu không có dữ liệu trong session
        if (selectedSeats == null || totalPrice == null || roomId == null || showtimeId == null) {
            return ResponseEntity.badRequest().body("Session data is missing.");
        }

        // Lặp qua từng ghế đã chọn và tạo booking cho từng ghế
        for (Map<String, Object> seatData : selectedSeats) {
            String seatRow = String.valueOf(seatData.get("row"));
            String seatColumn = String.valueOf(seatData.get("column"));

            // Tạo một booking cho mỗi ghế
            boolean isBookingCreated = createBooking(customer.getCustomer_id(), showtimeId, totalPrice);
            if (!isBookingCreated) {
                return ResponseEntity.status(500).body("Failed to create booking for seat: " + seatRow + "-" + seatColumn);
            }

            //Tao booking_seat
            int booking_id = bookingService.getLastBookingId();
            int seat_id = seatService.getSeatId(roomId, seatRow, seatColumn);
            boolean isBookingSeatCreated = bookingService.createBookingSeat(booking_id, seat_id);
            if (!isBookingSeatCreated) {
                return ResponseEntity.status(500).body("Failed to create booking_seat for seat: " + seatRow + "-" + seatColumn);
            }
        }

        System.out.println("Payload processed successfully."); // Log success
        return ResponseEntity.ok("Booking details saved in session.");
    }
}
