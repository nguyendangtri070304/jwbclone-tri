package com.group11.moviebooking.repository;

import com.group11.moviebooking.entity.CustomerEntity;
import com.group11.moviebooking.util.BasicImpl;
import com.group11.moviebooking.util.ConnectionPool;
import com.group11.moviebooking.util.ConnectionPoolImpl;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl extends BasicImpl implements CustomerRepository {
    private final ConnectionPool connectionPool;

    public CustomerRepositoryImpl() {
        super("tblcustomers");
        this.connectionPool = ConnectionPoolImpl.getInstance();
    }

    @Override
    public boolean add(CustomerEntity customer) {
        String checkCustomerQuery = "SELECT * FROM tblcustomers WHERE customer_email = ?";
        String insertSQL = "INSERT INTO tblcustomers (customer_name, customer_email, customer_password, " + "customer_phone, customer_date_of_birth, customer_gender, customer_is_active) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = connectionPool.getConnection("CustomerServiceImpl.add")) {
            // Kiểm tra xem email đã tồn tại chưa
            try (PreparedStatement checkStmt = connection.prepareStatement(checkCustomerQuery)) {
                checkStmt.setString(1, customer.getCustomer_email());
                try (ResultSet resultSet = checkStmt.executeQuery()) {
                    if (resultSet.next()) {
                        return false; // Email đã tồn tại
                    }
                }
            }
            // Thêm khách hàng mới
            try (PreparedStatement pstmt = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, customer.getCustomer_name());
                pstmt.setString(2, customer.getCustomer_email());
                pstmt.setString(3, customer.getCustomer_password());
                pstmt.setString(4, customer.getCustomer_phone());
                pstmt.setString(5, customer.getCustomer_date_of_birth());
                pstmt.setString(6, customer.getCustomer_gender());
                pstmt.setByte(7, customer.getCustomer_is_active());
                int i = pstmt.executeUpdate();
                if (i <= 0) {
                    return false; // Không thể thêm khách hàng
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean registerCustomer(CustomerEntity customer) {
        String checkCustomerQuery = "SELECT * FROM tblcustomers WHERE customer_email = ?";
        String insertCustomerQuery = "INSERT INTO tblcustomers (customer_name, customer_email, customer_password, customer_is_active) VALUES (?, ?, ?,true)";
        try (Connection connection = connectionPool.getConnection("CustomerServiceImpl.registerCustomer")) {
            // Check if customer already exists
            try (PreparedStatement checkStmt = connection.prepareStatement(checkCustomerQuery)) {
                checkStmt.setString(1, customer.getCustomer_email());
                try (ResultSet resultSet = checkStmt.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Tài khoản đã tồn tại. Vui lòng nhập lại email.");
                        return false;
                    }
                }
            }
            // Insert new customer
            try (PreparedStatement insertStmt = connection.prepareStatement(insertCustomerQuery, Statement.RETURN_GENERATED_KEYS)) {
                insertStmt.setString(1, customer.getCustomer_name());
                insertStmt.setString(2, customer.getCustomer_email());
                insertStmt.setString(3, customer.getCustomer_password());
                int i = insertStmt.executeUpdate();
                return i > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
//    @Override
//    public boolean add(CustomerEntity customer) {
    // CustomerEntity check =
    // this.getUserByCustomerEmail(customer.getCustomer_email());
//        if (check != null) {
//            return false; // Admin với email đã tồn tại
//        }
//
    // String sql = "INSERT INTO tblcustomers (customer_name, customer_email,
    // customer_password) VALUES (?, ?, md5(?));";
//        try {
//            PreparedStatement pre = this.con.prepareStatement(sql);
//            pre.setString(1, customer.getCustomer_name());
//            pre.setString(2, customer.getCustomer_email());
//            pre.setString(3, customer.getCustomer_password());
//            pre.executeUpdate(); // Thực thi câu lệnh INSERT
//
//            // Nếu đang sử dụng giao dịch, hãy chắc chắn bạn gọi commit()
//            this.con.commit();
//
//            return true;
//        } catch (SQLException e) {
//                System.out.println("lôi rồi");
//            e.printStackTrace();
//            try {
//                // Rollback nếu có lỗi xảy ra
//                this.con.rollback();
//            } catch (SQLException rollbackEx) {
//                rollbackEx.printStackTrace();
//            }
//        }
//        return false;
//    }

    @Override
    public boolean edit(CustomerEntity customer) {
        String sql = "UPDATE tblcustomers SET customer_name = ?, customer_email = ?, customer_password = ?, customer_phone = ?, customer_date_of_birth = ?, customer_is_active=?, customer_gender=?  WHERE customer_id = ?";
        try (Connection connection = connectionPool.getConnection("CustomerServiceImpl.editCustomer");
             PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, customer.getCustomer_name());
            pre.setString(2, customer.getCustomer_email());
            pre.setString(3, customer.getCustomer_password());
            pre.setString(4, customer.getCustomer_phone());
            pre.setString(5, customer.getCustomer_date_of_birth());
            pre.setByte(6, customer.getCustomer_is_active());
            pre.setString(7, customer.getCustomer_gender());
            pre.setLong(8, customer.getCustomer_id());
            int rowsUpdated = pre.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public boolean updateCustomerStatus(long customer_id) {
        Byte newStatus = 0;
        String checkCustomerQuery = "SELECT customer_is_active FROM moviebooking_data.tblcustomers WHERE customer_id = ?";
        String updateStatusQuery = "UPDATE tblcustomers SET customer_is_active = ? WHERE customer_id = ?";
        try (Connection connection = connectionPool.getConnection("CustomerServiceImpl.updateCustomerStatus")) {
            try (PreparedStatement checkStmt = connection.prepareStatement(checkCustomerQuery)) {
                checkStmt.setLong(1, customer_id);
                ResultSet resultSet = checkStmt.executeQuery();
                if (resultSet.next()) {
                    newStatus = (byte) ((resultSet.getByte("customer_is_active") == 0) ? 1 : 0);
                }
            }
            try (PreparedStatement updateStmt = connection.prepareStatement(updateStatusQuery, Statement.RETURN_GENERATED_KEYS)) {
                updateStmt.setByte(1, newStatus);
                updateStmt.setLong(2, customer_id);
                int rowsUpdated = updateStmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Cập nhật trạng thái khách hàng thành công! " + rowsUpdated);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public List<CustomerEntity> getAllActiveCustomers() {
        return List.of();
    }

    @Override
    public List<CustomerEntity> getAllInactiveCustomers() {
        return List.of();
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        List<CustomerEntity> customers = new ArrayList<>();
        String sql = "SELECT * FROM tblcustomers";
        try (Connection connection = connectionPool.getConnection("CustomerServiceImpl.getAllCustomers");
             PreparedStatement pre = connection.prepareStatement(sql)) {
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    CustomerEntity customer = new CustomerEntity();
                    customer.setCustomer_id(rs.getLong("customer_id"));
                    customer.setCustomer_name(rs.getString("customer_name"));
                    customer.setCustomer_email(rs.getString("customer_email"));
                    customer.setCustomer_password(rs.getString("customer_password"));
                    customer.setCustomer_phone(rs.getString("customer_phone"));
                    customer.setCustomer_date_of_birth(rs.getString("customer_date_of_birth"));
                    customer.setCustomer_gender(rs.getString("customer_gender"));
                    customer.setCustomer_created_at(rs.getString("customer_created_at"));
                    customer.setCustomer_is_active(rs.getByte("customer_is_active"));
                    customers.add(customer);
                }
            }
        } catch (SQLException e) {
            // Replace printStackTrace with a logging framework
            System.err.println("Error fetching all customers: " + e.getMessage());
        }
        return customers;
    }

    @Override
    public CustomerEntity getUserByCustomerEmail(String customer_email) {
        CustomerEntity customer = null;
        String sql = "SELECT * FROM tblcustomers WHERE customer_email = ?";
        try (Connection connection = connectionPool.getConnection("CustomerServiceImpl.getUserByCustomerEmail"); PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, customer_email);  // Bind the parameter
            try (ResultSet rs = pre.executeQuery()) {
                if (rs.next()) {
                    customer = new CustomerEntity();
                    customer.setCustomer_id(rs.getLong("customer_id"));
                    customer.setCustomer_name(rs.getString("customer_name"));
                    customer.setCustomer_email(rs.getString("customer_email"));
                    customer.setCustomer_password(rs.getString("customer_password"));
                    customer.setCustomer_phone(rs.getString("customer_phone"));
                    customer.setCustomer_date_of_birth(rs.getString("customer_date_of_birth"));
                    customer.setCustomer_gender(rs.getString("customer_gender"));
                    customer.setCustomer_created_at(rs.getString("customer_created_at"));
                    customer.setCustomer_is_active(rs.getByte("customer_is_active"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public CustomerEntity getUserByCustomerEmailAndPassword(String customer_email, String password) {
        CustomerEntity customer = null;
        String sql = "SELECT * FROM tblcustomers WHERE customer_email = ? AND customer_password = md5(?)";
        try (Connection connection = connectionPool.getConnection("CustomerServiceImpl.getUserByCustomerEmailAndPassword"); PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, customer_email); // Bind customer email parameter
            pre.setString(2, password); // Bind password parameter
            try (ResultSet rs = pre.executeQuery()) {
                // If a record exists
                if (rs.next()) {
                    customer = new CustomerEntity();
                    customer.setCustomer_id(rs.getLong("customer_id"));
                    customer.setCustomer_name(rs.getString("customer_name"));
                    customer.setCustomer_email(rs.getString("customer_email"));
                    customer.setCustomer_password(rs.getString("customer_password"));
                    customer.setCustomer_phone(rs.getString("customer_phone"));
                    customer.setCustomer_date_of_birth(rs.getString("customer_date_of_birth"));
                    customer.setCustomer_gender(rs.getString("customer_gender"));
                    customer.setCustomer_created_at(rs.getString("customer_created_at"));
                    customer.setCustomer_is_active(rs.getByte("customer_is_active"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer; // Return null if no user is found
    }

    @Override
    public CustomerEntity getUserbyID(Long customer_id) {
        CustomerEntity customer = null;
        String sql = "SELECT * FROM tblcustomers WHERE customer_id =?";
        try (Connection connection = connectionPool.getConnection("CustomerServiceImpl.getUserbyID");
             PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setLong(1, customer_id); // Bind the parameter
            try (ResultSet rs = pre.executeQuery()) {
                if (rs.next()) {
                    customer = new CustomerEntity();
                    customer.setCustomer_id(rs.getLong("customer_id"));
                    customer.setCustomer_name(rs.getString("customer_name"));
                    customer.setCustomer_email(rs.getString("customer_email"));
                    customer.setCustomer_password(rs.getString("customer_password"));
                    customer.setCustomer_phone(rs.getString("customer_phone"));
                    customer.setCustomer_date_of_birth(rs.getString("customer_date_of_birth"));
                    customer.setCustomer_gender(rs.getString("customer_gender"));
                    customer.setCustomer_created_at(rs.getString("customer_created_at"));
                    customer.setCustomer_is_active(rs.getByte("customer_is_active"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<CustomerEntity> getUserByName(String name) {
        List<CustomerEntity> customers = new ArrayList<>();
        String sql = "SELECT * FROM tblcustomers WHERE customer_name LIKE ?";
        try (Connection connection = connectionPool.getConnection("CustomerServiceImpl.getUserByName");
             PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, "%" + name + "%"); // Use wildcard to match partial names
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    CustomerEntity customer = new CustomerEntity();
                    customer.setCustomer_id(rs.getLong("customer_id"));
                    customer.setCustomer_name(rs.getString("customer_name"));
                    customer.setCustomer_email(rs.getString("customer_email"));
                    customer.setCustomer_password(rs.getString("customer_password"));
                    customer.setCustomer_phone(rs.getString("customer_phone"));
                    customer.setCustomer_date_of_birth(rs.getString("customer_date_of_birth"));
                    customer.setCustomer_gender(rs.getString("customer_gender"));
                    customer.setCustomer_created_at(rs.getString("customer_created_at"));
                    customer.setCustomer_is_active(rs.getByte("customer_is_active"));
                    customers.add(customer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
