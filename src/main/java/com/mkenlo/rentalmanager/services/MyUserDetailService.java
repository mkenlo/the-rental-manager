package com.mkenlo.rentalmanager.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mkenlo.rentalmanager.models.Role;
import com.mkenlo.rentalmanager.models.User;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);

    @Override
    public UserDetails loadUserByUsername(String username) {
        User loggedUser = userService.findByUsername(username);
        if (loggedUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        logger.info("the loggedUser is " + loggedUser.toString());
        return new org.springframework.security.core.userdetails.User(
                loggedUser.getUsername(), loggedUser.getPassword(), getAuthorities(loggedUser));

    }

    List<GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }

}
