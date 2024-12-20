package com.group11.moviebooking.repository;

import com.group11.moviebooking.entity.MovieEntity;

import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface MovieRepository {

    List<MovieEntity> getMovies(MovieEntity similar, int at, byte total);
    List<MovieEntity> getMoviesByTitle(String movie_title);
    String getMovies(int movie_id);
    List<MovieEntity> getAllMovies();
    ArrayList<MovieEntity> getLatestMovies();
    ArrayList<MovieEntity> getTopMovieByRating();
    ArrayList<MovieEntity> getMoviesForAdults();
    ArrayList<MovieEntity> getMoviesForKids();
    ResultSet getTopSellingMovies();
    HashMap<Object, Object> getTicketsSoldAndRevenue();
    boolean addMovie(MovieEntity entity);
    boolean updateMovie(MovieEntity entity);
    boolean deleteMovie(int id);
}
