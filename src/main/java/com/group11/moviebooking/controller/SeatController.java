package com.group11.moviebooking.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group11.moviebooking.model.SeatDTO;
import com.group11.moviebooking.model.ShowTimeDTO;
import com.group11.moviebooking.service.SeatService;
import com.group11.moviebooking.service.ShowTimeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class SeatController {

    private SeatService seatService;
    private ShowTimeService showtimeService;

    public SeatController(SeatService seatService, ShowTimeService showtimeService) {
        this.seatService = seatService;
        this.showtimeService = showtimeService;
    }

    @GetMapping("/seat")
    //@ResponseBody
    public ModelAndView showSeats(@RequestParam("movie_id") int movie_id,
                                  @RequestParam("room_id") int room_id,
                                  @RequestParam("start_time") String start_time,
                                  HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("/seat_sel");
        ShowTimeDTO showtime = showtimeService.getShowTimeByMovieRoomTime(movie_id, room_id, start_time);

        List<SeatDTO> soldSeats = seatService.getSoldSeats(movie_id, showtime.getShow_date(), showtime.getStart_time(), showtime.getEnd_time());

        // Chuyển danh sách ghế thành chuỗi JSON
        ObjectMapper mapper = new ObjectMapper();
        String jsonSoldSeats = "";
        try {
            jsonSoldSeats = mapper.writeValueAsString(soldSeats);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("JSON seats: " + jsonSoldSeats);
        modelAndView.addObject("room_id", room_id);
        modelAndView.addObject("movie_id", movie_id);
        modelAndView.addObject("showtime_id", showtime.getShowtime_id());
        modelAndView.addObject("show_date", showtime.getShow_date());
        modelAndView.addObject("ticket_price", showtime.getTicket_price());
        modelAndView.addObject("start_time", showtime.getStart_time());
        modelAndView.addObject("end_time", showtime.getEnd_time());
        modelAndView.addObject("soldseats", jsonSoldSeats);

        // Lưu dữ liệu vào session
        session.setAttribute("soldSeats", jsonSoldSeats);
        session.setAttribute("showtime_id", showtime.getShowtime_id());
        session.setAttribute("room_id", room_id);
        session.setAttribute("movie_id", movie_id);
        session.setAttribute("ticket_price", showtime.getTicket_price());
        session.setAttribute("start_time", start_time);
        session.setAttribute("show_date", showtime.getShow_date());


        System.out.println("movie id: " + movie_id);
        System.out.print(" room id: " + room_id);
        System.out.print(" start time: " + start_time);
        return modelAndView;
    }

    @PostMapping("/your-controller-endpoint")
    public ResponseEntity<String> handleSeatSelection(@RequestBody Map<String, Object> data, HttpSession session) {
        List<Map<String, Object>> selectedSeats = (List<Map<String, Object>>) data.get("selectedSeats");
        Integer totalPrice = (Integer) data.get("totalPrice");
        Integer room_id = (Integer) data.get("room_id");
        String seats = "";

        // Xử lý các ghế đã chọn và giá trị tổng
        System.out.println("Room ID: " + room_id);
        System.out.println("Selected seats: " + selectedSeats);
        System.out.println("Total price: " + totalPrice);

        // Duyệt qua các ghế đã chọn và gọi phương thức createSeat để lưu vào CSDL
        for (Map<String, Object> seatData : selectedSeats) {
            String seat_row = String.valueOf(seatData.get("row"));
            String seat_column = String.valueOf(seatData.get("column"));
            seats = seats + "R" + seat_row + '-' + "S" + seat_column + "  ";

            // Gọi phương thức createSeat của SeatService để lưu ghế vào cơ sở dữ liệu
            boolean isCreated = seatService.createSeat(room_id, seat_row, seat_column);
            if (isCreated) {
                System.out.println("Seat created successfully: " + seat_row + "-" + seat_column);
            } else {
                System.out.println("Failed to create seat: " + seat_row + "-" + seat_column);
            }
        }
        // Lưu dữ liệu ghế đã chọn vào session
        session.setAttribute("selectedSeats", selectedSeats);
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("room_id", room_id);
        session.setAttribute("seats", seats);

        // Trả về phản hồi thành công
        return ResponseEntity.ok("Seats selected: " + selectedSeats + ", Total price: " + totalPrice);
    }
}