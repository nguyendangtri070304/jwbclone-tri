package com.group11.moviebooking.repository;


import com.group11.moviebooking.entity.CustomerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository {
    boolean add(CustomerEntity customer);

    boolean edit(CustomerEntity customer);

    boolean del(long customer_id);

    List<CustomerEntity> getAllActiveCustomers();

    List<CustomerEntity> getAllInactiveCustomers();

    List<CustomerEntity> getAllCustomers();

    CustomerEntity getUserByCustomerEmail(String customer_email);

    List<CustomerEntity> getUserByName(String name);

    CustomerEntity getUserByCustomerEmailAndPassword(String customer_email, String password);
}
