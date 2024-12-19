package com.group11.moviebooking.repository;

public interface BookingRepository {
    boolean createBooking(long customer_id, int showtime_id, int total_price);

    boolean ceateBookingSeat(int booking_id, int seat_id);

    int getLastBookingId();
}
