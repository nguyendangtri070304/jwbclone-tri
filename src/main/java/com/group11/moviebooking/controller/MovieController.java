package com.group11.moviebooking.controller;


import com.group11.moviebooking.entity.MovieEntity;
import com.group11.moviebooking.model.MovieDTO;
import com.group11.moviebooking.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {


    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movie")
    public List<MovieDTO> getMovies(@RequestParam(value = "title", required = false) String title,
                                    @RequestParam(value = "genre", required = false) String genre,
                                    @RequestParam(value = "director", required = false) String director,
                                    @RequestParam(value = "age", required = false) Integer age,
                                    @RequestParam(value = "rating", required = false) Float rating,
                                    @RequestParam(value = "at", defaultValue = "0") int at,
                                    @RequestParam(value = "total", defaultValue = "10") byte total){



        MovieEntity similar = new MovieEntity();

        similar.setMovie_title(title);
        similar.setMovie_genre(genre);
        similar.setMovie_director(director);
        similar.setMovie_for_age(age != null ? age : 0);
        similar.setMovie_rating(rating != null ? rating : 0);

        return movieService.getMovies(similar, at, total);
    }

    @GetMapping("/movie_title")
    public ModelAndView getMovies(@RequestParam(value = "title") String title){
        ArrayList<MovieDTO> movies = movieService.getMovies(title);
        ModelAndView modelAndView = new ModelAndView("/search_movies");
        modelAndView.addObject("movies", movies);
        return modelAndView;
    }

    @GetMapping("/latest")
    public ArrayList<MovieDTO> getLatestMovies(){
        ArrayList<MovieDTO> movies = movieService.getLatestMovies();
        return movies;
    }

    @GetMapping("/rating")
    public ArrayList<MovieDTO> getTopMovieByRating(){
        ArrayList<MovieDTO> movies = movieService.getTopMovieByRating();
        return movies;
    }


    @GetMapping("/adults")
    public ArrayList<MovieDTO> getMoviesForAdults(){
        ArrayList<MovieDTO> movies = movieService.getMoviesForAdults();
        return movies;
    }

    @GetMapping("/kids")
    public ArrayList<MovieDTO> getMoviesForKids(){
        ArrayList<MovieDTO> movies = movieService.getMoviesForKids();
        return movies;
    }

    @GetMapping("/selling")
    public ArrayList<MovieDTO> getTopSellingMovies(){
        ArrayList<MovieDTO> movies = movieService.getTopSellingMovies();
        return movies;
    }

}
