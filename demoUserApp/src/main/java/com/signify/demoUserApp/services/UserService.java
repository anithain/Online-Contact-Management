package com.signify.demoUserApp.services;

import com.signify.demoUserApp.entity.Customer;

import java.util.List;

public interface UserService {
    Customer addUser(Customer user);

    Customer getUserById(Long userId);

    Customer updateUser(Long userId, Customer user);

    void deleteUser(Long userId);

    List<Customer> getAllUsers();
}
