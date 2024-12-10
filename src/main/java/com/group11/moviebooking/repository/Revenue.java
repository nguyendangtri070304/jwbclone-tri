package com.group11.moviebooking.repository;

import com.group11.moviebooking.model.RevenueDTO;

import java.util.List;

public interface Revenue {
    List<RevenueDTO> findWeekRevenue();
}
