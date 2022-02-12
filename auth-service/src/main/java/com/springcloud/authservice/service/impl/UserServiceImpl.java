package com.springcloud.authservice.service.impl;

import com.springcloud.authservice.entity.User;
import com.springcloud.authservice.repository.UserRepository;
import com.springcloud.authservice.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean login(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user != null) {
            passwordEncoder.matches(user.getPassword(), password);
        }
        return true;
    }

    @Override
    public String getUsernameById(int id) {
        User user = userRepository.findUserById(id);
        return user.getUsername();
    }
}
