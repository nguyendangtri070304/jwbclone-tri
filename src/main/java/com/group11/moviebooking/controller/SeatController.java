package com.group11.moviebooking.controller;


import com.group11.moviebooking.model.SeatDTO;
import com.group11.moviebooking.model.ShowTimeDTO;
import com.group11.moviebooking.service.SeatService;
import com.group11.moviebooking.service.ShowTimeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SeatController {

    private SeatService seatService;
    private ShowTimeService showtimeService;

    public SeatController(SeatService seatService, ShowTimeService showtimeService) {
        this.seatService = seatService;
        this.showtimeService = showtimeService;
    }

    @GetMapping("/seat")
    @ResponseBody
    public List<SeatDTO> showSeats(@RequestParam("movie_id") int movie_id,
                                  @RequestParam("room_id") int room_id,
                                  @RequestParam("start_time") String start_time) {
        //ModelAndView modelAndView = new ModelAndView("/seat_sel");
        ShowTimeDTO showtime = showtimeService.getShowTimeByMovieRoomTime(movie_id, room_id, start_time);

        List<SeatDTO> soldSeats = seatService.getSoldSeats(movie_id, showtime.getShow_date(), showtime.getStart_time(), showtime.getEnd_time());
        //modelAndView.addObject("soldseats", soldSeats);

        System.out.print("movie id: " + movie_id);
        System.out.print("room id: " + room_id);
        System.out.print("start time: " + start_time);

        return soldSeats;
    }
}
