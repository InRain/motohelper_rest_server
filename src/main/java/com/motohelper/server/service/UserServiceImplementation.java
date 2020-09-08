package com.motohelper.server.service;

import com.motohelper.server.model.Role;
import com.motohelper.server.model.Status;
import com.motohelper.server.model.User;
import com.motohelper.server.repository.RoleRepository;
import com.motohelper.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService{


    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder){
      this.userRepository=userRepository;
      this.passwordEncoder=passwordEncoder;
      this.roleRepository=roleRepository;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User register(User user) {
        Role userRole = roleRepository.findByName("USER");
        List<Role> roleList = new ArrayList<>();
        roleList.add(userRole);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roleList);
        user.setStatus(Status.ACTIVE);

       User registered = userRepository.saveAndFlush(user);
       return registered;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUserName(username);
        return result;
    }

    @Override
    public void save(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
