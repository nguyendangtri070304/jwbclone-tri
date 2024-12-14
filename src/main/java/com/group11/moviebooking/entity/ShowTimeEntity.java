package com.group11.moviebooking.entity;

public class ShowTimeEntity {
    private int showtime_id;
    private int movie_id;
    private int room_id;
    private String show_date;
    private String start_time;
    private String end_time;
    private int ticket_price;
    private String showtime_created_at;
    private String showtime_updated_at;

    // Getter và Setter cho showtime_id
    public int getShowtime_id() {
        return showtime_id;
    }

    public void setShowtime_id(int showtime_id) {
        this.showtime_id = showtime_id;
    }

    // Getter và Setter cho movie_id
    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    // Getter và Setter cho room_id
    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    // Getter và Setter cho show_date
    public String getShow_date() {
        return show_date;
    }

    public void setShow_date(String show_date) {
        this.show_date = show_date;
    }

    // Getter và Setter cho start_time
    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    // Getter và Setter cho end_time
    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    // Getter và Setter cho ticket_price
    public int getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(int ticket_price) {
        this.ticket_price = ticket_price;
    }

    // Getter và Setter cho showtime_created_at
    public String getShowtime_created_at() {
        return showtime_created_at;
    }

    public void setShowtime_created_at(String showtime_created_at) {
        this.showtime_created_at = showtime_created_at;
    }

    // Getter và Setter cho showtime_updated_at
    public String getShowtime_updated_at() {
        return showtime_updated_at;
    }

    public void setShowtime_updated_at(String showtime_updated_at) {
        this.showtime_updated_at = showtime_updated_at;
    }
}
