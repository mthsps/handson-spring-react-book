package com.org.cardatabase.service;

import com.org.cardatabase.model.User;
import com.org.cardatabase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImplementation implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        User currentUser = repository.findByUsername(username);

        return new org.springframework.security.core.userdetails.User(username, currentUser.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList(currentUser.getRole()));
    }
}
