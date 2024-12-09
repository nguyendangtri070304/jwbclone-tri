package com.group11.moviebooking.controller;


import com.group11.moviebooking.model.MovieDTO;
import com.group11.moviebooking.service.MovieService;
import com.group11.moviebooking.util.MovieEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieCọntroller {

    private MovieService movieService;

    public MovieCọntroller(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("api/movies")
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

    @GetMapping("api/movies-movie_title")
    public ModelAndView getMovies(@RequestParam(value = "title") String movie_title){
        List<MovieDTO> movies = movieService.getMovies(movie_title);
        ModelAndView modelAndView = new ModelAndView("/search-movie");
        modelAndView.addObject("movies", movies);
        return modelAndView;
    }

    @GetMapping("api/movies/latest")
    public ArrayList<MovieDTO> getLatestMovies(){
        ArrayList<MovieDTO> movies = movieService.getLatestMovies();
        return movies;
    }

    @GetMapping("api/movies/rating")
    public ArrayList<MovieDTO> getTopMovieByRating(){
        ArrayList<MovieDTO> movies = movieService.getLatestMovies();
        return movies;
    }

}
