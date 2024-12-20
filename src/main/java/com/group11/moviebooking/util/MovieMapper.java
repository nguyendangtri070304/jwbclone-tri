package com.group11.moviebooking.util;

import com.group11.moviebooking.entity.MovieEntity;
import com.group11.moviebooking.model.MovieDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper {

    public static MovieDTO mapEntityToDTO(MovieEntity movieEntity) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovie_id(movieEntity.getMovie_id());
        movieDTO.setMovie_title(movieEntity.getMovie_title());
        movieDTO.setMovie_description(movieEntity.getMovie_description());
        movieDTO.setMovie_rating(movieEntity.getMovie_rating());
        movieDTO.setMovie_duration(movieEntity.getMovie_duration());
        movieDTO.setMovie_trailer_url(movieEntity.getMovie_trailer_url());
        movieDTO.setMovie_release_date(movieEntity.getMovie_release_date());
        movieDTO.setMovie_main_actor(movieEntity.getMovie_main_actor());
        movieDTO.setMovie_director(movieEntity.getMovie_director());
        movieDTO.setMovie_studio(movieEntity.getMovie_studio());
        movieDTO.setMovie_country(movieEntity.getMovie_country());
        movieDTO.setMovie_genre(movieEntity.getMovie_genre());
        movieDTO.setMovie_for_age(movieEntity.getMovie_for_age());
        movieDTO.setMovie_poster_url(movieEntity.getMovie_poster_url());

        return movieDTO;
    }

    public static MovieDTO mapResultSetToDTO(ResultSet rs) throws SQLException {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovie_id(rs.getInt("movie_id"));
        movieDTO.setMovie_title(rs.getString("movie_title"));
        movieDTO.setMovie_description(rs.getString("movie_description"));
        movieDTO.setMovie_rating(rs.getFloat("movie_rating"));
        movieDTO.setMovie_duration(rs.getInt("movie_duration"));
        movieDTO.setMovie_trailer_url(rs.getString("movie_trailer_url"));
        movieDTO.setMovie_release_date(rs.getString("movie_release_date"));
        movieDTO.setMovie_main_actor(rs.getString("movie_main_actor"));
        movieDTO.setMovie_director(rs.getString("movie_director"));
        movieDTO.setMovie_studio(rs.getString("movie_studio"));
        movieDTO.setMovie_country(rs.getString("movie_country"));
        movieDTO.setMovie_genre(rs.getString("movie_genre"));
        movieDTO.setMovie_for_age(rs.getInt("movie_for_age"));
        movieDTO.setMovie_poster_url(rs.getString("movie_poster_url"));
        return movieDTO;
    }
}
