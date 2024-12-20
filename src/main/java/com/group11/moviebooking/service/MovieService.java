package com.group11.moviebooking.service;


import com.group11.moviebooking.entity.MovieEntity;
import com.group11.moviebooking.model.MovieDTO;
import com.group11.moviebooking.repository.MovieRepositoryImpl;
import com.group11.moviebooking.util.MovieMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepositoryImpl movieRepositoryImpl;

    public MovieService(MovieRepositoryImpl movieRepositoryImpl) {
        this.movieRepositoryImpl = movieRepositoryImpl;
    }

    public List<MovieDTO> getMovies(MovieEntity similar, int at, byte total) {
        List<MovieEntity> movieEntities = movieRepositoryImpl.getMovies(similar, at, total);
        List<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();

        for (MovieEntity movieEntity : movieEntities) {
            MovieDTO movieDTO = MovieMapper.mapEntityToDTO(movieEntity);
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    public ArrayList<MovieDTO> getMovies(String movie_title) {
        ArrayList<MovieEntity> movieEntities = movieRepositoryImpl.getMoviesByTitle(movie_title);
        ArrayList<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();
        for (MovieEntity movieEntity : movieEntities) {
            MovieDTO movieDTO = MovieMapper.mapEntityToDTO(movieEntity);
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    public ArrayList<MovieDTO> getallMovies() {
        ArrayList<MovieEntity> movieEntities = (ArrayList<MovieEntity>) movieRepositoryImpl.getAllMovies();
        ArrayList<MovieDTO> movieDTOs = new ArrayList<>();
        for (MovieEntity movieEntity : movieEntities) {
            MovieDTO movieDTO = MovieMapper.mapEntityToDTO(movieEntity);
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    public ArrayList<MovieDTO> getallMoviesLimit(int limit) {
        ArrayList<MovieEntity> movieEntities = (ArrayList<MovieEntity>) movieRepositoryImpl.getAllMoviesLimit(limit);
        ArrayList<MovieDTO> movieDTOs = new ArrayList<>();
        for (MovieEntity movieEntity : movieEntities) {
            MovieDTO movieDTO = MovieMapper.mapEntityToDTO(movieEntity);
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    public ArrayList<MovieDTO> getLatestMovies() {
        ArrayList<MovieEntity> movieEntities = movieRepositoryImpl.getLatestMovies();
        ArrayList<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();

        for (MovieEntity movieEntity : movieEntities) {
            MovieDTO movieDTO = MovieMapper.mapEntityToDTO(movieEntity);
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    public ArrayList<MovieDTO> getTopMovieByRating() {
        ArrayList<MovieEntity> movieEntities = movieRepositoryImpl.getTopMovieByRating();
        ArrayList<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();

        for (MovieEntity movieEntity : movieEntities) {
            MovieDTO movieDTO = MovieMapper.mapEntityToDTO(movieEntity);
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    public ArrayList<MovieDTO> getMoviesForAdults() {
        ArrayList<MovieEntity> movieEntities = movieRepositoryImpl.getMoviesForAdults();
        ArrayList<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();

        for (MovieEntity movieEntity : movieEntities) {
            MovieDTO movieDTO = MovieMapper.mapEntityToDTO(movieEntity);
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    public ArrayList<MovieDTO> getMoviesForKids() {
        ArrayList<MovieEntity> movieEntities = movieRepositoryImpl.getMoviesForKids();
        ArrayList<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();

        for (MovieEntity movieEntity : movieEntities) {
            MovieDTO movieDTO = MovieMapper.mapEntityToDTO(movieEntity);
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

    public ArrayList<MovieDTO> getTopSellingMovies() {
        ResultSet rs = movieRepositoryImpl.getTopSellingMovies();
        ArrayList<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();
        try {
            if (rs == null) {
                return movieDTOs;
            }
            while (rs.next()) {
                MovieDTO movie = new MovieDTO();
                movie.setMovie_id(rs.getInt("movie_id"));
                movie.setMovie_title(rs.getString("movie_title"));
                movie.setMovie_poster_url(rs.getString("movie_poster_url"));
                movie.setMovie_release_date(rs.getString("movie_release_date"));
                movie.setMovie_description(rs.getString("movie_description"));
                movie.setMovie_director(rs.getString("movie_director"));
                movie.setMovie_duration(rs.getInt("movie_duration"));
                movie.setMovie_studio(rs.getString("movie_studio"));
                movie.setMovie_rating(rs.getFloat("movie_rating"));
                movie.setMovie_main_actor(rs.getString("movie_main_actor"));
                movie.setTotal_tickets_sold(rs.getInt("total_tickets_sold"));
                movie.setTicket_price(rs.getFloat("ticket_price"));
                movie.setRevenue(rs.getFloat("revenue"));
                movieDTOs.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieDTOs;
    }

    public HashMap<Object, Object> getTicketsSoldAndRevenue() {

        HashMap<Object, Object> resultMap = movieRepositoryImpl.getTicketsSoldAndRevenue();

        return resultMap;
    }

    public String getMovie(int movie_id) {
        return movieRepositoryImpl.getMovies(movie_id);
    }
}





