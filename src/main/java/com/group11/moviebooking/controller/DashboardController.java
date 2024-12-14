package com.group11.moviebooking.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.group11.moviebooking.convert.MappingDTOtoJSON;
import com.group11.moviebooking.model.MovieDTO;
import com.group11.moviebooking.model.RevenueDTO;
import com.group11.moviebooking.service.MovieService;
import com.group11.moviebooking.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class DashboardController {

    private MovieService movieService;
    private RevenueService revenueService;
    private MappingDTOtoJSON map;

    @Autowired
    public DashboardController(MovieService movieService, RevenueService revenueService) {
        this.movieService = movieService;
        this.revenueService = revenueService;
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard(){
        ModelAndView modelAndView = new ModelAndView("/dashboard");

        HashMap<Object, Object> report = getTicketsSoldAndRevenue();
        modelAndView.addObject("total_tickets_sold", report.get("total_tickets_sold"));
        modelAndView.addObject("total_revenue", report.get("total_revenue"));

        List<RevenueDTO> chart = getRevenueForLast7Days();
        try {
            ObjectMapper mapper = new ObjectMapper();
            String chartJson = mapper.writeValueAsString(chart); // Chuyển đổi thành JSON
            modelAndView.addObject("chart", chartJson);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<MovieDTO> topSelling = getTopSellingMovies();
        try {
            ObjectMapper mapper = new ObjectMapper();
            String chartJson = mapper.writeValueAsString(topSelling); // Chuyển đổi thành JSON
            modelAndView.addObject("topselling", topSelling);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return modelAndView;
    }


    public HashMap<Object, Object> getTicketsSoldAndRevenue(){
        return movieService.getTicketsSoldAndRevenue();
    }

    public List<RevenueDTO> getRevenueForLast7Days() {
        return revenueService.findWeekRevenue();
    }

    public ArrayList<MovieDTO> getTopSellingMovies(){
        return movieService.getTopSellingMovies();
    }
}
