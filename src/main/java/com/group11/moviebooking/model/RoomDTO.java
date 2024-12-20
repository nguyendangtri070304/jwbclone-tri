package com.group11.moviebooking.model;

public class RoomDTO {
    private Integer room_id;
    private String room_name;
    private Short room_capacity;
    private String room_location;
    private String room_screen_type;
    private String room_sound_system;
    private String room_created_at;

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public Short getRoom_capacity() {
        return room_capacity;
    }

    public void setRoom_capacity(Short room_capacity) {
        this.room_capacity = room_capacity;
    }

    public String getRoom_location() {
        return room_location;
    }

    public void setRoom_location(String room_location) {
        this.room_location = room_location;
    }

    public String getRoom_screen_type() {
        return room_screen_type;
    }

    public void setRoom_screen_type(String room_screen_type) {
        this.room_screen_type = room_screen_type;
    }

    public String getRoom_sound_system() {
        return room_sound_system;
    }

    public void setRoom_sound_system(String room_sound_system) {
        this.room_sound_system = room_sound_system;
    }

    public String getRoom_created_at() {
        return room_created_at;
    }

    public void setRoom_created_at(String room_created_at) {
        this.room_created_at = room_created_at;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "room_id=" + room_id +
                ", room_name='" + room_name + '\'' +
                ", room_capacity=" + room_capacity +
                ", room_location='" + room_location + '\'' +
                ", room_screen_type='" + room_screen_type + '\'' +
                ", room_sound_system='" + room_sound_system + '\'' +
                ", room_created_at='" + room_created_at + '\'' +
                "}\n";
    }
}
