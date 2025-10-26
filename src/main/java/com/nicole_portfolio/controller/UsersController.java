package com.nicole_portfolio.controller;

import com.nicole_portfolio.entity.Users;
import com.nicole_portfolio.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public Users validateLogin(@RequestBody LoginRequest loginRequest) {
        return usersService.validateLogin(loginRequest.getUsername(), loginRequest.getPassword());
    }

    public static class LoginRequest {
        private String username;
        private String password;

        // getters e setters
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
