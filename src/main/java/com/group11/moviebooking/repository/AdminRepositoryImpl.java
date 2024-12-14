package com.group11.moviebooking.repository;

import com.group11.moviebooking.entity.AdminEntity;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminRepositoryImpl extends BasicImpl implements AdminRepository {

    public AdminRepositoryImpl() {
        super("tbladmins");
    }

    @Override
    public List<AdminEntity> getAllAdmins() {
        List<AdminEntity> adminList = new ArrayList<>();

        String query = "SELECT * FROM tbladmins";

        try (
                PreparedStatement preparedStatement = this.con.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet != null) {
                while (resultSet.next()) {
                    AdminEntity admin = new AdminEntity();
                    admin.setAdmin_id(resultSet.getLong("admin_id"));
                    admin.setAdmin_name(resultSet.getString("admin_name"));
                    admin.setAdmin_email(resultSet.getString("admin_email"));
                    admin.setAdmin_password(resultSet.getString("admin_password"));
                    admin.setAdmin_phone(resultSet.getString("admin_phone"));
                    admin.setAdmins_created_at(resultSet.getString("admins_created_at"));
                    admin.setAdmins_is_active(resultSet.getByte("admins_is_active"));
                    adminList.add(admin);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception properly in production code
        }
        return adminList;
    }

    @Override
    public AdminEntity getAdminByEmail(String email) {
        String query = "SELECT * FROM tbladmins WHERE admin_email = ?";
        try (PreparedStatement preparedStatement = this.con.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet != null) {
                    if (resultSet.next()) {
                        AdminEntity admin = new AdminEntity();
                        admin.setAdmin_id(resultSet.getLong("admin_id"));
                        admin.setAdmin_name(resultSet.getString("admin_name"));
                        admin.setAdmin_email(resultSet.getString("admin_email"));
                        admin.setAdmin_password(resultSet.getString("admin_password"));
                        admin.setAdmin_phone(resultSet.getString("admin_phone"));
                        admin.setAdmins_created_at(resultSet.getString("admins_created_at"));
                        admin.setAdmins_is_active(resultSet.getByte("admins_is_active"));
                        return admin;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception properly in production code
        }
        return null;
    }

    @Override
    public List<AdminEntity> getAdminByName(String name) {
        List<AdminEntity> adminList = new ArrayList<>();
        String query = "SELECT * FROM tbladmins WHERE admin_name LIKE ?";
        try (PreparedStatement preparedStatement = this.con.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + name + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet == null) {
                    return null;
                }
                while (resultSet.next()) {
                    AdminEntity admin = new AdminEntity();
                    admin.setAdmin_id(resultSet.getLong("admin_id"));
                    admin.setAdmin_name(resultSet.getString("admin_name"));
                    admin.setAdmin_email(resultSet.getString("admin_email"));
                    admin.setAdmin_password(resultSet.getString("admin_password"));
                    admin.setAdmin_phone(resultSet.getString("admin_phone"));
                    admin.setAdmins_created_at(resultSet.getString("admins_created_at"));
                    admin.setAdmins_is_active(resultSet.getByte("admins_is_active"));
                    adminList.add(admin);
                }
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception properly in production code
        }
        return adminList;
    }

    @Override
    public AdminEntity getAdminByEmailAndPassword(String email, String password) {
        String query = "SELECT * FROM tbladmins WHERE admin_email = ? AND admin_password = md5(?)";
        try (PreparedStatement preparedStatement = this.con.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet != null && resultSet.next()) {
                    AdminEntity admin = new AdminEntity();
                    admin.setAdmin_id(resultSet.getLong("admin_id"));
                    admin.setAdmin_name(resultSet.getString("admin_name"));
                    admin.setAdmin_email(resultSet.getString("admin_email"));
                    admin.setAdmin_password(resultSet.getString("admin_password"));
                    admin.setAdmin_phone(resultSet.getString("admin_phone"));
                    admin.setAdmins_created_at(resultSet.getString("admins_created_at"));
                    admin.setAdmins_is_active(resultSet.getByte("admins_is_active"));
                    return admin;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception properly in production code
        }
        return null;
    }

    @Override
    public boolean add(AdminEntity entity) {
        AdminEntity check = this.getAdminByEmail(entity.getAdmin_email());
        if (check != null) {
            return false; // Admin with the given email already exists
        }
        String insertQuery = "INSERT INTO tbladmins (admin_name, admin_email, admin_password) VALUES (?, ?, md5(?))";
        try (PreparedStatement insertStatement = this.con.prepareStatement(insertQuery)) {
            insertStatement.setString(1, entity.getAdmin_name());
            insertStatement.setString(2, entity.getAdmin_email());
            insertStatement.setString(3, entity.getAdmin_password());
            return insertStatement.executeUpdate() > 0; // Return true if insert succeeded
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean add(String sql) {
        try (PreparedStatement insertStatement = this.con.prepareStatement(sql)) {
            return insertStatement.executeUpdate() > 0; // Return true if insert succeeded
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(AdminEntity entity) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
