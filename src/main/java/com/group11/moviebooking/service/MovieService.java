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

    private MovieRepositoryImpl movieRepositoryImpl;

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
        ArrayList<MovieEntity> movieEntities = movieRepositoryImpl.getMovies(movie_title);
        ArrayList<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();

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

    public ArrayList<MovieDTO> getTopSellingMovies(){
        ResultSet rs = movieRepositoryImpl.getTopSellingMovies();
        ArrayList<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();
        try {
            while(rs.next()) {
                MovieDTO movie = new MovieDTO();
                movie.setMovie_title(rs.getString("movie_title"));
                movie.setMovie_poster_url(rs.getString("movie_poster_url"));
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

    public HashMap<Object,Object> getTicketsSoldAndRevenue() {

        HashMap<Object, Object> resultMap = movieRepositoryImpl.getTicketsSoldAndRevenue();

        return resultMap;
    }
}





