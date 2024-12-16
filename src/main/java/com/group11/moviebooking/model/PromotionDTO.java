package com.group11.moviebooking.model;

public class PromotionDTO {
    private int promotion_id;
    private String promotion_name;
    private int promotion_discount_percentage;
    private String promotion_start_date;
    private String promotion_end_date;
    private String promotion_conditions;
    private String promotion_description;


    public int getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(int  promotion_id) {
        this.promotion_id = promotion_id;
    }

    public String getPromotion_name() {
        return promotion_name;
    }

    public void setPromotion_name(String promotion_name) {
        this.promotion_name = promotion_name;
    }

    public int getPromotion_discount_percentage() {
        return promotion_discount_percentage;
    }

    public void setPromotion_discount_percentage(int promotion_discount_percentage) {
        this.promotion_discount_percentage = promotion_discount_percentage;
    }

    public String getPromotion_start_date() {
        return promotion_start_date;
    }

    public void setPromotion_start_date(String promotion_start_date) {
        this.promotion_start_date = promotion_start_date;
    }

    public String getPromotion_end_date() {
        return promotion_end_date;
    }

    public void setPromotion_end_date(String promotion_end_date) {
        this.promotion_end_date = promotion_end_date;
    }

    public String getPromotion_conditions() {
        return promotion_conditions;
    }

    public void setPromotion_conditions(String promotion_conditions) {
        this.promotion_conditions = promotion_conditions;
    }

    public String getPromotion_description() {
        return promotion_description;
    }

    public void setPromotion_description(String promotion_description) {
        this.promotion_description = promotion_description;
    }
}
