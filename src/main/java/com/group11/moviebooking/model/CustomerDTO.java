package com.group11.moviebooking.model;

public class CustomerDTO {
    private long customer_id;
    private String customer_name;
    private String customer_email;
    private String customer_password;
    private String customer_Confirm_password;
    private String customer_phone;
    private String customer_date;
    private String customer_month;
    private String customer_year;
    private String customer_gender;
    private String customer_created_at;
    private byte customer_is_active;
    private String customer_date_of_birth;

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getCustomer_Confirm_password() {
        return customer_Confirm_password;
    }

    public void setCustomer_Confirm_password(String customer_Confirm_password) {
        this.customer_Confirm_password = customer_Confirm_password;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_date_of_birth() {

        return customer_date_of_birth;
    }

    public void setCustomer_date_of_birth(String customer_date_of_birth) {
        this.customer_date_of_birth = customer_date_of_birth;
    }

    public String getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(String customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_created_at() {
        return customer_created_at;
    }

    public void setCustomer_created_at(String customer_created_at) {
        this.customer_created_at = customer_created_at;
    }

    public byte getCustomer_is_active() {
        return customer_is_active;
    }

    public void setCustomer_is_active(byte customer_is_active) {
        this.customer_is_active = customer_is_active;
    }

    public String getCustomer_date() {
        return customer_date;
    }

    public void setCustomer_date(String customer_date) {
        this.customer_date = customer_date;
    }

    public String getCustomer_month() {
        return customer_month;
    }

    public void setCustomer_month(String customer_month) {
        this.customer_month = customer_month;
    }

    public String getCustomer_year() {
        return customer_year;
    }

    public void setCustomer_year(String customer_year) {
        this.customer_year = customer_year;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", customer_email='" + customer_email + '\'' +
                ", customer_password='" + customer_password + '\'' +
                ", customer_Confirm_password='" + customer_Confirm_password + '\'' +
                ", customer_phone='" + customer_phone + '\'' +
                ", customer_date_of_birth='" + customer_date_of_birth + '\'' +
                ", customer_gender='" + customer_gender + '\'' +
                ", customer_created_at='" + customer_created_at + '\'' +
                ", customer_is_active=" + customer_is_active +
                "}\n";
    }
}
