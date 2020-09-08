package com.motohelper.server.service;

import com.motohelper.server.model.User;


import java.util.List;

public interface UserService {

    User getById(Long id);
    User register(User user);
    void save(User user);
    void delete(Long id);
    List<User> getAll();
    User findByUsername(String username);
}
