package com.motohelper.server.security;

import com.motohelper.server.model.User;
import com.motohelper.server.security.jwt.JwtUserFactory;
import com.motohelper.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByUsername(s);

        if (user == null){
            throw new UsernameNotFoundException("User " + s +" not found");
        }

        return JwtUserFactory.create(user);
    }
}
