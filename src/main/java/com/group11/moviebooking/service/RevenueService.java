package com.group11.moviebooking.service;


import com.group11.moviebooking.model.RevenueDTO;
import com.group11.moviebooking.repository.RevenueImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueService {
    private RevenueImpl revenueImpl;

    public RevenueService( RevenueImpl revenueImpl) { this.revenueImpl = revenueImpl;}

    public List<RevenueDTO> findWeekRevenue(){
        return revenueImpl.findWeekRevenue();
    }
}
