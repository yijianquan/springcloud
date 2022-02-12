package com.springcloud.authservice.service;

public interface UserService {

    boolean login(String username, String password);

    String getUsernameById(int id);
}
