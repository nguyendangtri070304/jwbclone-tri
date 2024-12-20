package com.group11.moviebooking.entity;

public class SeatEntity {
    private int seat_id;
    private int room_id;
    private String seat_row;
    private String seat_column;
    private final SeatStatus seat_status = SeatStatus.AVAILABLE;

    public enum SeatStatus {AVAILABLE, RESERVED, BOOKED}

    // Getter và Setter
    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getSeat_row() {
        return seat_row;
    }

    public void setSeat_row(String seat_row) {
        this.seat_row = seat_row;
    }

    public String getSeat_column() {
        return seat_column;
    }

    public void setSeat_column(String seat_column) {
        this.seat_column = seat_column;
    }
}
