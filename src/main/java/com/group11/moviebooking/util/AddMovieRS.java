package com.group11.moviebooking.util;

import com.group11.moviebooking.entity.MovieEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AddMovieRS {

    public static List<MovieEntity> addMovieRSToList(ResultSet rs, List<MovieEntity> movies) {
        try {
            MovieEntity movie = new MovieEntity();
            movie.setMovie_id(rs.getInt("movie_id"));
            movie.setMovie_title(rs.getString("movie_title"));
            movie.setMovie_description(rs.getString("movie_description"));
            movie.setMovie_rating(rs.getFloat("movie_rating"));
            movie.setMovie_duration(rs.getInt("movie_duration"));
            movie.setMovie_trailer_url(rs.getString("movie_trailer_url"));
            movie.setMovie_release_date(rs.getString("movie_release_date"));
            movie.setMovie_created_at(rs.getString("movie_created_at"));
            movie.setMovie_main_actor(rs.getString("movie_main_actor"));
            movie.setMovie_director(rs.getString("movie_director"));
            movie.setMovie_studio(rs.getString("movie_studio"));
            movie.setMovie_country(rs.getString("movie_country"));
            movie.setMovie_genre(rs.getString("movie_genre"));
            movie.setMovie_for_age(rs.getInt("movie_for_age"));
            movie.setMovie_poster_url(rs.getString("movie_poster_url"));
            movies.add(movie);
            return movies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
