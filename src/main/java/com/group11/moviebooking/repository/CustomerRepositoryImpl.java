package com.group11.moviebooking.repository;


import com.group11.moviebooking.entity.CustomerEntity;
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
public class CustomerRepositoryImpl extends BasicImpl implements CustomerRepository {
    private final ConnectionPool connectionPool;

    public CustomerRepositoryImpl() {
        super("tblcustomers");
        this.connectionPool = ConnectionPoolImpl.getInstance();
    }

    @Override
    public boolean add(CustomerEntity customer) {
        CustomerEntity check = this.getUserByCustomerEmail(customer.getCustomer_email());
        if (check != null) {
            return false; // Admin with the given email already exists
        }
        String sql = "INSERT INTO tblcustomers (customer_name, customer_email, customer_password) VALUES (?, ?, md5(?));";
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, customer.getCustomer_name());
            pre.setString(2, customer.getCustomer_email());
            pre.setString(3, customer.getCustomer_password());
            pre.executeUpdate(); // Execute the insert statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void registerCustomer(CustomerEntity customer) throws Exception {
        try (Connection connection = connectionPool.getConnection("CustomerServiceImpl.registerCustomer")) {
            // Check if customer already exists
            String checkCustomerQuery = "SELECT * FROM tblcustomers WHERE customer_email = ?";
            try (PreparedStatement checkStmt = connection.prepareStatement(checkCustomerQuery)) {
                checkStmt.setString(1, customer.getCustomer_email());
                try (ResultSet resultSet = checkStmt.executeQuery()) {
                    if (resultSet.next()) {
                        throw new Exception("Tài khoản đã tồn tại. Vui lòng nhập lại email.");
                    }
                }
            }
            // Insert new customer
            String insertCustomerQuery = "INSERT INTO tblcustomers (customer_name, customer_email, customer_password, customer_is_active) VALUES (?, ?, md5(?),true)";
            try (PreparedStatement insertStmt = connection.prepareStatement(insertCustomerQuery)) {
                insertStmt.setString(1, customer.getCustomer_name());
                insertStmt.setString(2, customer.getCustomer_email());
                insertStmt.setString(3, customer.getCustomer_password());
                insertStmt.executeUpdate();
            }
        }
    }
//    @Override
//    public boolean add(CustomerEntity customer) {
//        CustomerEntity check = this.getUserByCustomerEmail(customer.getCustomer_email());
//        if (check != null) {
//            return false; // Admin với email đã tồn tại
//        }
//
//        String sql = "INSERT INTO tblcustomers (customer_name, customer_email, customer_password) VALUES (?, ?, md5(?));";
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
        return false;
    }

    @Override
    public boolean del(long customer_id) {
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

        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs != null) {
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
            // Alternatively, handle logging for SQL exceptions
        }

        return customers;
    }

    @Override
    public CustomerEntity getUserByCustomerEmail(String customer_email) {
        CustomerEntity customer = null;
        String sql = "SELECT * FROM tblcustomers WHERE customer_email =?";
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, customer_email);  // Bind the parameter

            ResultSet rs = pre.executeQuery();

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
        } catch (SQLException e) {
            e.printStackTrace();
            // Consider using a logger instead of printing directly in production code
        }

        return customer;
    }

    @Override
    public CustomerEntity getUserByCustomerEmailAndPassword(String customer_email, String password) {
        CustomerEntity customer = null;
        String sql = "SELECT * FROM tblcustomers WHERE customer_email = ? AND customer_password = md5(?)";
        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, customer_email); // Bind customer email parameter
            pre.setString(2, password); // Bind password parameter

            ResultSet rs = pre.executeQuery();

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
            rs.close(); // Close the ResultSet after use
        } catch (SQLException e) {
            e.printStackTrace();
            // As mentioned earlier, consider logging errors in production-ready code
        }

        return customer; // Return null if no user is found
    }

    @Override
    public List<CustomerEntity> getUserByName(String name) {
        List<CustomerEntity> customers = new ArrayList<>();
        String sql = "SELECT * FROM tblcustomers WHERE customer_name LIKE ?";

        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, "%" + name + "%"); // Use wildcard to match partial names

            ResultSet rs = pre.executeQuery();

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
        } catch (SQLException e) {
            e.printStackTrace();
            // Prefer logging instead of printing exceptions in production
        }
        return customers;
    }
}
