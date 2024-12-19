package com.group11.moviebooking.controller;

import com.group11.moviebooking.model.ShowTimeDTO;
import com.group11.moviebooking.service.MovieService;
import com.group11.moviebooking.service.ShowTimeService;
import jakarta.servlet.RequestDispatcher;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.StringWriter;
import java.util.*;

@RestController
public class ShowTimeController {

    private final MovieService movieService;
    private final ShowTimeService showtimeService;

    public ShowTimeController(MovieService movieService, ShowTimeService showtimeService) {
        this.movieService = movieService;
        this.showtimeService = showtimeService;
    }

    public List<ShowTimeDTO> getShowTimeByMovieAndDate(int movie_id, String show_date) {
        return showtimeService.getShowTimeByMovieAndDate(movie_id, show_date);
    }

    public List<ShowTimeDTO> getShowTimeByMovieId(int movie_id) {
        return showtimeService.getShowTimeByMovieId(movie_id);
    }

    @GetMapping("/ticket-booking")
    public ModelAndView showShowTimes(@RequestParam("movie_id") int movie_id) {
        ModelAndView modelAndView = new ModelAndView("/ticket-booking");

        if (movie_id == -1) {
            modelAndView.setViewName("error");
            modelAndView.addObject("errorMessage", "Invalid movie ID.");
            return modelAndView;
        }

        List<ShowTimeDTO> showtimes = getShowTimeByMovieId(movie_id);
        Set<String> uniqueDates = new LinkedHashSet<>();
        Map<String, List<ShowTimeDTO>> showtimesByDate = new LinkedHashMap<>();

        // Tổ chức danh sách showtimes theo ngày
        for (ShowTimeDTO showtime : showtimes) {
            uniqueDates.add(showtime.getShow_date());
            showtimesByDate.computeIfAbsent(showtime.getShow_date(), k -> new ArrayList<>()).add(showtime);
        }

        modelAndView.addObject("uniqueDates", uniqueDates);
        modelAndView.addObject("showtimesByDate", showtimesByDate);  // Thêm danh sách showtimes theo ngày
        modelAndView.addObject("movie_id", movie_id);

        return modelAndView;
    }

    @GetMapping("/showrooms")
    @ResponseBody
    public List<ShowTimeDTO> getShowrooms(@RequestParam("movie_id") int movie_id,
                                          @RequestParam("show_date") String show_date) {
        System.out.println("Movie ID: " + movie_id + ", Show Date: " + show_date);  // Kiểm tra tham số nhận được
        List<ShowTimeDTO> showtimes = showtimeService.getShowTimeByMovieAndDate(movie_id, show_date);

        System.out.println("Showtimes: " + showtimes);  // Kiểm tra dữ liệu trả về
        return showtimes;
    }

}
