package com.group11.moviebooking.model;

public class RevenueDTO {
    private String showDate;
    private Double totalRevenue;

    public RevenueDTO(String showDate, Double totalRevenue) {
        this.showDate = showDate;
        this.totalRevenue = totalRevenue;
    }

    // Getters and Setters
    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
