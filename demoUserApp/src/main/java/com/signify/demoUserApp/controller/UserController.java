package com.signify.demoUserApp.controller;

import com.signify.demoUserApp.entity.Customer;
import com.signify.demoUserApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Customer addUser(@RequestBody Customer user){
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public Customer getUserById(@PathVariable("id") Long userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/{id}")
    public Customer updateUser(@PathVariable("id") Long userId, @RequestBody Customer user){
        return userService.updateUser(userId,user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return "User deleted Successfully";
    }
    @GetMapping("/")
    public List<Customer> getAllUsers(){
        return userService.getAllUsers();
    }


}
