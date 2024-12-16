package com.group11.moviebooking.controller;

import com.group11.moviebooking.model.ShowTimeDTO;
import com.group11.moviebooking.service.MovieService;
import com.group11.moviebooking.service.ShowTimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ShowTimeController {

    private final MovieService movieService;
    private final ShowTimeService showtimeService;
    public ShowTimeController(MovieService movieService, ShowTimeService showtimeService) {
        this.movieService = movieService;
        this.showtimeService = showtimeService;
    }

    @GetMapping("/show")
    public List<ShowTimeDTO> getShowtimeByMovieId(@RequestParam("movie_id") int movie_id) {
        return showtimeService.getShowTimeByMovieId(movie_id);
    }
    public List<ShowTimeDTO> getShowTimeByMovieAndDate(@RequestParam("movie_id") int movie_id, @RequestParam("show_date") String show_date) {
        return showtimeService.getShowTimeByMovieAndDate(movie_id, show_date);
    }

    @GetMapping("/ticket-booking")
    public ModelAndView showShowTimes(@RequestParam("movie_id") int movie_id) {
        ModelAndView modelAndView = new ModelAndView("/ticket-booking");
        if (movie_id == -1) {
            // Nếu movie_id không hợp lệ hoặc bị thiếu, trả về trang lỗi
            modelAndView.setViewName("error");
            modelAndView.addObject("errorMessage", "Invalid movie ID.");
            return modelAndView;
        }
        // Lấy danh sách showtime cho movie_id
        List<ShowTimeDTO> showtimes = showtimeService.getShowTimeByMovieId(movie_id);

        // Lọc các ngày duy nhất
        Set<String> uniqueDates = new LinkedHashSet<>();
        for (ShowTimeDTO showtime : showtimes) {
            uniqueDates.add(showtime.getShow_date());
        }

        // Gửi dữ liệu đến JSP
        modelAndView.addObject("uniqueDates", uniqueDates);
        modelAndView.addObject("showtimes", showtimes);
        modelAndView.addObject("movie_id", movie_id);  // Truyền movie_id đến JSP

        return modelAndView;
    }

    @GetMapping("/showrooms")
    public ModelAndView showRooms(@RequestParam("movie_id") int movie_id, @RequestParam("show_date") String show_date) {
        ModelAndView modelAndView = new ModelAndView("/ticket-booking");

        // Lấy danh sách phòng chiếu cho movie_id và show_date
        List<ShowTimeDTO> showtimes = showtimeService.getShowTimeByMovieAndDate(movie_id, show_date);
        Set<Integer> uniqueRooms = new LinkedHashSet<>();
        for (ShowTimeDTO showtime : showtimes) {
            uniqueRooms.add(showtime.getRoom_id());
        }

        modelAndView.addObject("uniqueRooms", uniqueRooms);
        modelAndView.addObject("showtimes", showtimes);
        modelAndView.addObject("movie_id", movie_id);  // Truyền lại movie_id để sử dụng tiếp

        return modelAndView;
    }

    @GetMapping("/showtimes")
    public ModelAndView showTimesByRoom(@RequestParam("movie_id") int movie_id, @RequestParam("show_date") String show_date, @RequestParam("room_id") int room_id) {
        ModelAndView modelAndView = new ModelAndView("/ticket-booking");

        // Lấy danh sách giờ chiếu cho movie_id, show_date và room_id
        List<ShowTimeDTO> showtimes = showtimeService.getShowTimesByRoom(movie_id, show_date, room_id);
        modelAndView.addObject("showtimes", showtimes);
        modelAndView.addObject("movie_id", movie_id);  // Truyền lại movie_id để sử dụng tiếp

        return modelAndView;
    }
}
