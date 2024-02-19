package com.signify.demoUserApp.services;

import com.signify.demoUserApp.repository.UserRepository;
import com.signify.demoUserApp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Customer addUser(Customer user) {
        return userRepository.save(user);
    }

    @Override
    public Customer getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public Customer updateUser(Long userId, Customer user) {
        if(userRepository.existsById(userId)){
            user.setUserId(userId);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<Customer> getAllUsers() {
        return userRepository.findAll();
    }
}
