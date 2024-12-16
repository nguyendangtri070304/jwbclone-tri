package com.group11.moviebooking.repository;

import com.group11.moviebooking.entity.AdminEntity;

import java.util.List;

public interface AdminRepository {
    List<AdminEntity> getAllAdmins();

    AdminEntity getAdminByEmail(String email);

    List<AdminEntity> getAdminByName(String name);

    AdminEntity getAdminByEmailAndPassword(String email, String password);

    boolean add(AdminEntity entity);
    boolean update(AdminEntity entity);
    boolean delete(Long id);
}
