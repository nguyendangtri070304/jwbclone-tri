package com.group11.moviebooking.service;

import com.group11.moviebooking.repository.AdminRepositoryImpl;
import com.group11.moviebooking.entity.AdminEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private AdminRepositoryImpl adminRepositoryImpl;
    public AdminService(AdminRepositoryImpl adminRepositoryImpl) {
        this.adminRepositoryImpl = adminRepositoryImpl;
    }

    public String sql = "use moviebooking_data;"
            + "INSERT INTO tbladmins(admin_name, admin_email, admin_password) "
            + "VALUES ('hoinguyen', 'hoinguyen17@gmail.com', md5('ditmemay'));";

    // Admin-related methods
    public boolean add2(String sql) {
        return this.adminRepositoryImpl.add(sql);
    }
    public AdminEntity getAdminByEmailAndPassword(String email, String password) {
        return this.adminRepositoryImpl.getAdminByEmailAndPassword(email, password);
    }
    public AdminEntity getAdminByEmail(String email) {
        return this.adminRepositoryImpl.getAdminByEmail(email);
    }
    public List<AdminEntity> getallAdmin() {
        return this.adminRepositoryImpl.getAllAdmins();
    }
}
