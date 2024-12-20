package com.group11.moviebooking.entity;

public class AdminEntity {
    private Long admin_id;
    private String admin_name;
    private String admin_email;
    private String admin_password;
    private String admin_phone;
    private String admins_created_at;
    private Byte admins_is_active;

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_phone() {
        return admin_phone;
    }

    public void setAdmin_phone(String admin_phone) {
        this.admin_phone = admin_phone;
    }

    public String getAdmins_created_at() {
        return admins_created_at;
    }

    public void setAdmins_created_at(String admins_created_at) {
        this.admins_created_at = admins_created_at;
    }

    public Byte getAdmins_is_active() {
        return admins_is_active;
    }

    public void setAdmins_is_active(Byte admins_is_active) {
        this.admins_is_active = admins_is_active;
    }

    @Override
    public String toString() {
        return "AdminEntity{\n" +
                "admin_id=" + admin_id +
                ", admin_name='" + admin_name + '\'' +
                ", admin_email='" + admin_email + '\'' +
                ", admin_password='" + admin_password + '\'' +
                ", admin_phone='" + admin_phone + '\'' +
                ", admins_created_at='" + admins_created_at + '\'' +
                ", admins_is_active=" + admins_is_active +
                "\n}";
    }
}
