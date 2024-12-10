package com.group11.moviebooking.service;

import com.group11.moviebooking.model.ShowTimeDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowTimeService {

    public List<ShowTimeDTO> getShowTimeByMovie(int movie_id){
        List<ShowTimeDTO> showtimes = new ArrayList<ShowTimeDTO>();

        return showtimes;
    }

    public ShowTimeDTO getShowTimeById(int showtime_id){
        ShowTimeDTO showtime = new ShowTimeDTO();

        return showtime;
    }
}
