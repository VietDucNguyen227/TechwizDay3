package com.example.healthassistant.security.service;

import com.example.healthassistant.model.Users;
import com.example.healthassistant.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsersRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if(users == null){
            new UsernameNotFoundException("Login fail");
        }else {
            GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
            grantList.add(authority);
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(username,users.getPassword(),grantList);
            return userDetails;
        }

        return UserDetailsImpl.build(users);
    }
}
