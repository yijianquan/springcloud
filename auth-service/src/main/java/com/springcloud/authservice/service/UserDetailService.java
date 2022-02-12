package com.springcloud.authservice.service;

import com.springcloud.authservice.entity.Roles;
import com.springcloud.authservice.entity.User;
import com.springcloud.authservice.repository.RolesRepository;
import com.springcloud.authservice.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private RolesRepository rolesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);

        Roles roles = rolesRepository.findRolesByUsername(username);

        String[] userRoles = roles.getRoles().split(",");

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String userRole : userRoles) {
            SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_" + userRole);
            authorities.add(role);
        }
        user.setAuthorities(authorities);

        return user;
    }


}

