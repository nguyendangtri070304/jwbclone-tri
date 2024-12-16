package com.group11.moviebooking.repository;

import com.group11.moviebooking.entity.MovieEntity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface MovieRepository {

    List<MovieEntity> getMovies(MovieEntity similar, int at, byte total);
    List<MovieEntity> getMovies(String movie_title);
    ArrayList<MovieEntity> getLatestMovies();
    ArrayList<MovieEntity> getTopMovieByRating();
    ArrayList<MovieEntity> getMoviesForAdults();
    ArrayList<MovieEntity> getMoviesForKids();
    ResultSet getTopSellingMovies();
    HashMap<Object, Object> getTicketsSoldAndRevenue();

}
