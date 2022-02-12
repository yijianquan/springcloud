package com.springcloud.authservice.repository;

import com.springcloud.authservice.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    User findUserById(int id);

    User findUserByUsername(String username);

//    void updateUserByUsername(User user);
//
//    void deleteUserByUsername(String username);
//
//    void saveUser(User user);
//
//    List<User> getUserList();
}
