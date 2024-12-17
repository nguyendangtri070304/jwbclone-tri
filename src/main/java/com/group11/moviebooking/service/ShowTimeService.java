package com.group11.moviebooking.service;

import com.group11.moviebooking.convert.ShowTimeMapper;
import com.group11.moviebooking.entity.ShowTimeEntity;
import com.group11.moviebooking.model.ShowTimeDTO;
import com.group11.moviebooking.repository.ShowTimeRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowTimeService {

    private final ShowTimeRepositoryImpl showtimeRepositoryImpl;

    public ShowTimeService(ShowTimeRepositoryImpl showtimeRepositoryImpl){
        this.showtimeRepositoryImpl = showtimeRepositoryImpl;
    }

    public List<ShowTimeDTO> getShowTimeByMovieId(int movie_id){
        List<ShowTimeEntity> showtimeEntities = showtimeRepositoryImpl.getShowTimeByMovieId(movie_id);
        List<ShowTimeDTO> showtimeDTOs = new ArrayList<ShowTimeDTO>();

        for(ShowTimeEntity showtimeEntity : showtimeEntities){
            ShowTimeDTO showtimeDTO = ShowTimeMapper.mapEntityToDTO(showtimeEntity);
            showtimeDTOs.add(showtimeDTO);
        }
        return showtimeDTOs;
    }

    public List<ShowTimeDTO> getShowTimeByMovieAndDate(int movie_id, String show_date){
        List<ShowTimeEntity> showtimeEntities = showtimeRepositoryImpl.getShowTimeByMovieAndDate(movie_id, show_date);
        List<ShowTimeDTO> showtimeDTOs = new ArrayList<ShowTimeDTO>();

        for(ShowTimeEntity showtimeEntity : showtimeEntities){
            ShowTimeDTO showtimeDTO = ShowTimeMapper.mapEntityToDTO(showtimeEntity);
            showtimeDTOs.add(showtimeDTO);
        }
        return showtimeDTOs;
    }

    public List<ShowTimeDTO> getShowTimesByRoom(int movie_id, String show_date, int room_id){
        List<ShowTimeEntity> showtimeEntities = showtimeRepositoryImpl.getShowTimesByRoom(movie_id, show_date, room_id);
        List<ShowTimeDTO> showtimeDTOs = new ArrayList<ShowTimeDTO>();

        for(ShowTimeEntity showtimeEntity : showtimeEntities){
            ShowTimeDTO showtimeDTO = ShowTimeMapper.mapEntityToDTO(showtimeEntity);
            showtimeDTOs.add(showtimeDTO);
        }
        return showtimeDTOs;
    }

    public ShowTimeDTO getShowTimeById(int showtime_id){
        ShowTimeDTO showtime = new ShowTimeDTO();

        return showtime;
    }

}
