package com.group11.moviebooking.model;

public class BookingDTO {

    private int booking_id;
    private int customer_id;
    private int showtime_id;
    private float total_price;
    private String booking_created_at;

    // Getter and Setter for booking_id
    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    // Getter and Setter for customer_id
    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    // Getter and Setter for showtime_id
    public int getShowtime_id() {
        return showtime_id;
    }

    public void setShowtime_id(int showtime_id) {
        this.showtime_id = showtime_id;
    }

    // Getter and Setter for total_price
    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    // Getter and Setter for booking_created_at
    public String getBooking_created_at() {
        return booking_created_at;
    }

    public void setBooking_created_at(String booking_created_at) {
        this.booking_created_at = booking_created_at;
    }
}
