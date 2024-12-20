package com.group11.moviebooking.repository;

import com.group11.moviebooking.entity.AdminEntity;
import com.group11.moviebooking.util.ConnectionPool;
import com.group11.moviebooking.util.ConnectionPoolImpl;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminRepositoryImpl extends BasicImpl implements AdminRepository {
    private final ConnectionPool connectionPool;

    public AdminRepositoryImpl() {
        super("tbladmins");
        this.connectionPool = ConnectionPoolImpl.getInstance();
    }

    @Override
    public List<AdminEntity> getAllAdmins() {
        List<AdminEntity> adminList = new ArrayList<>();
        String query = "SELECT * FROM tbladmins";
        try (Connection connection = connectionPool.getConnection("AdminRepositoryImpl.getAllAdmins");
             PreparedStatement pre = connection.prepareStatement(query);
             ResultSet resultSet = pre.executeQuery()) {
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
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
            // Consider throwing a custom exception or returning an empty list
        } finally {
            this.releaseConnection();
        }
        return adminList;
    }

    @Override
    public AdminEntity getAdminByEmail(String email) {
        String query = "SELECT * FROM tbladmins WHERE admin_email = ?";
        try (Connection connection = connectionPool.getConnection("AdminRepositoryImpl.getAdminByEmail"); PreparedStatement pre = connection.prepareStatement(query)) {
            pre.setString(1, email);
            try (ResultSet resultSet = pre.executeQuery()) {
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
        } finally {
            this.releaseConnection();
        }
        return null;
    }

    @Override
    public List<AdminEntity> getAdminByName(String name) {
        List<AdminEntity> adminList = new ArrayList<>();
        String query = "SELECT * FROM tbladmins WHERE admin_name LIKE ?";
        try (Connection connection = connectionPool.getConnection("AdminRepositoryImpl.getAdminByName");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + name + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
            }
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
            // Handle exception properly in production code
        }
        return adminList;
    }

    @Override
    public AdminEntity getAdminByEmailAndPassword(String email, String password) {
        String query = "SELECT * FROM tbladmins WHERE admin_email = ? AND admin_password = md5(?)";
        try (Connection connection = connectionPool.getConnection("AdminRepositoryImpl.getAdminByEmailAndPassword");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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
        String insertQuery = "INSERT INTO tbladmins (admin_name, admin_email, admin_password) SELECT ?, ?, md5(?) WHERE NOT EXISTS (SELECT 1 FROM tbladmins WHERE admin_email = ?)";
        try (Connection connection = connectionPool.getConnection("AdminRepositoryImpl.add");
             PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            insertStatement.setString(1, entity.getAdmin_name());
            insertStatement.setString(2, entity.getAdmin_email());
            insertStatement.setString(3, entity.getAdmin_password());
            insertStatement.setString(4, entity.getAdmin_email());
            return insertStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
        }
        return false;
    }

    public boolean add(String sql) {
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
