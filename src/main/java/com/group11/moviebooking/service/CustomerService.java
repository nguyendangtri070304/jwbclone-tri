package com.group11.moviebooking.service;


import com.group11.moviebooking.util.BasicImpl;
import com.group11.moviebooking.repository.CustomerRepositoryImpl;
import com.group11.moviebooking.entity.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends BasicImpl {
    private final CustomerRepositoryImpl customerRepositoryImpl;

    public CustomerService(CustomerRepositoryImpl customerRepositoryImpl) {
        super("tblcustomers");
        this.customerRepositoryImpl = customerRepositoryImpl;
    }

    public List<CustomerEntity> getAllCustomers() {
        return this.customerRepositoryImpl.getAllCustomers();
    }

    public boolean checkUserToLogin(String email, String password) {
        CustomerEntity customer = new CustomerEntity();
        customer = this.customerRepositoryImpl.getUserByCustomerEmailAndPassword(email, password);
        if (customer == null) {
            return false;
        }
        return customer.getCustomer_is_active() != 0;
    }

    public boolean checkUserToRegister(String name, String email, String password) {
        CustomerEntity customer = new CustomerEntity();
//        CustomerEntity check = this.customerRepositoryImpl.getUserByCustomerEmail(email);
//        if (check != null) {
//            return false; // Email already exists
//        }
        customer.setCustomer_name(name);
        customer.setCustomer_email(email);
        customer.setCustomer_password(password);
        customer.setCustomer_is_active((byte) 1);
        return this.customerRepositoryImpl.add(customer);
    }
    public boolean add (CustomerEntity customer) {
        try {
            this.customerRepositoryImpl.registerCustomer(customer);
            System.out.println("Đăng ký thành công!");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public CustomerEntity getCustomerByEmailAndPassword(String email, String password) {
        return this.customerRepositoryImpl.getUserByCustomerEmailAndPassword(email, password);
    }

    public CustomerEntity getCustomerByEmail(String email) {
        return this.customerRepositoryImpl.getUserByCustomerEmail(email);
    }
}
