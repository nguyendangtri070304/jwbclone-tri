package com.group11.moviebooking.service;


import com.group11.moviebooking.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private BookingRepository bookingRepository;
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    public boolean createBooking(long customer_id, int showtime_id, int total_price){
        return bookingRepository.createBooking(customer_id, showtime_id, total_price);
    }

    public boolean createBookingSeat(int booking_id, int seat_id){
        return bookingRepository.ceateBookingSeat(booking_id, seat_id);
    }

    public int getLastBookingId(){
        return bookingRepository.getLastBookingId();
    }
}
