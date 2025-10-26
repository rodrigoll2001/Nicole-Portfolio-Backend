package com.nicole_portfolio.service;

import com.nicole_portfolio.entity.Users;

public interface UsersService {
    Users validateLogin(String username, String rawPassword);
}
