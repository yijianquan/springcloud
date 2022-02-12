package com.springcloud.authservice.repository;

import com.springcloud.authservice.entity.Roles;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolesRepository {

    Roles findRolesByUsername(String username);
}
