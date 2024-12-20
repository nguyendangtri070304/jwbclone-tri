package com.group11.moviebooking.service;

import com.group11.moviebooking.entity.CustomerEntity;
import com.group11.moviebooking.model.CustomerDTO;
import com.group11.moviebooking.repository.CustomerRepositoryImpl;
import com.group11.moviebooking.util.BasicImpl;
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

    public boolean updateCustomerStatus(Long CustomerId) throws Exception {
        return this.customerRepositoryImpl.updateCustomerStatus(CustomerId);
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

    public boolean registerCustomer(CustomerEntity customer) {
        try {
            this.customerRepositoryImpl.registerCustomer(customer);
            System.out.println("Đăng ký thành công!");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean addCustomer(CustomerEntity customer) {
        return this.customerRepositoryImpl.add(customer);
    }

    public CustomerEntity getCustomerByEmailAndPassword(String email, String password) {
        return this.customerRepositoryImpl.getUserByCustomerEmailAndPassword(email, password);
    }

    public CustomerEntity getCustomerByEmail(String email) {
        return this.customerRepositoryImpl.getUserByCustomerEmail(email);
    }

    public CustomerEntity getCustomerbyId(Long customerId) {
        return this.customerRepositoryImpl.getUserbyID(customerId);
    }

    public boolean edit(CustomerEntity customer) {
        return this.customerRepositoryImpl.edit(customer);
    }

    public CustomerEntity ConvertCustomerDTOtoCustomer(CustomerDTO customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomer_name(customer.getCustomer_name());
        customerEntity.setCustomer_email(customer.getCustomer_email());
        customerEntity.setCustomer_password(customer.getCustomer_password());
        customerEntity.setCustomer_phone(customer.getCustomer_phone());
        customerEntity.setCustomer_date_of_birth(customer.getCustomer_date_of_birth());
        customerEntity.setCustomer_gender(customer.getCustomer_gender());
        customerEntity.setCustomer_is_active(customer.getCustomer_is_active());
        return customerEntity;
    }

    public boolean CheckCustomerToRegister(CustomerDTO customerDTO) {
        return (customerDTO.getCustomer_Confirm_password() != null && customerDTO.getCustomer_password().equals(customerDTO.getCustomer_Confirm_password()));
    }

}
