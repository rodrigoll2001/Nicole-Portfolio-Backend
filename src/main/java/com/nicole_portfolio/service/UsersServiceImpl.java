package com.nicole_portfolio.service;

import com.nicole_portfolio.entity.Users;
import com.nicole_portfolio.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import com.nicole_portfolio.util.PasswordUtil;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users validateLogin(String username, String rawPassword) {
        return usersRepository.findByUsername(username)
                .filter(user -> PasswordUtil.checkPassword(rawPassword, user.getPasswordHash()))
                .orElseThrow(() -> new RuntimeException("Usuário ou senha inválidos"));
    }
}
