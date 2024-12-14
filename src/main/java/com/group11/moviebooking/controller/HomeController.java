package com.group11.moviebooking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group11.moviebooking.convert.MappingDTOtoJSON;
import com.group11.moviebooking.model.MovieDTO;
import com.group11.moviebooking.model.RevenueDTO;
import com.group11.moviebooking.service.MovieService;
import com.group11.moviebooking.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class HomeController {

    private MovieService movieService;
    private RevenueService revenueService;
    private MappingDTOtoJSON map;

    @Autowired
    public HomeController(MovieService movieService, RevenueService revenueService) {
        this.movieService = movieService;
        this.revenueService = revenueService;
    }

    @GetMapping("/home")
    public ModelAndView showDashboard(){
        ModelAndView modelAndView = new ModelAndView("/index");

        List<MovieDTO> latestMovies = movieService.getLatestMovies();;
        modelAndView.addObject("latestMovies", latestMovies);

        List<MovieDTO> topRatingMovies = movieService.getTopMovieByRating();
        modelAndView.addObject("topRatingMovies", topRatingMovies);

        List<MovieDTO> popularMovies = movieService.getTopSellingMovies();
        modelAndView.addObject("popularMovies", popularMovies);

        return modelAndView;
    }
}

