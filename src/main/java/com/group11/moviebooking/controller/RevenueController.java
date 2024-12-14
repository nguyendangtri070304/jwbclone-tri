package com.group11.moviebooking.controller;

import com.group11.moviebooking.model.RevenueDTO;
import com.group11.moviebooking.service.RevenueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RevenueController {
    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @GetMapping("/api/revenue")
    public List<RevenueDTO> getRevenueForLast7Days() {
        return revenueService.findWeekRevenue();
    }
}
