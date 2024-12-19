package com.group11.moviebooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SeatSelectionController {

    @RequestMapping("/seat_sel")
    public String showSeatSelectionPage() {
        return "seat_sel"; // Sẽ tìm kiếm seat_sel.jsp trong thư mục templates
    }
}