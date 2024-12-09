package com.group11.moviebooking.service;


import com.group11.moviebooking.model.MovieDTO;
import com.group11.moviebooking.repository.MovieRepositoryImpl;
import com.group11.moviebooking.util.MovieEntity;
import com.group11.moviebooking.util.MovieMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<MovieDTO> getMovies(String movie_title) {
        List<MovieEntity> movieEntities = movieRepositoryImpl.getMovies(movie_title);
        List<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();

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

    public ArrayList<MovieDTO> getTopMovieByRating(){
        ArrayList<MovieEntity> movieEntities = movieRepositoryImpl.getLatestMovies();
        ArrayList<MovieDTO> movieDTOs = new ArrayList<MovieDTO>();

        for (MovieEntity movieEntity : movieEntities) {
            MovieDTO movieDTO = MovieMapper.mapEntityToDTO(movieEntity);
            movieDTOs.add(movieDTO);
        }
        return movieDTOs;
    }

}





