package com.springcloud.authservice.entity;

import org.apache.ibatis.type.Alias;

@Alias("roles")
public class Roles {

    private String username;

    private String roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
