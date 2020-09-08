package com.motohelper.server.service;

import com.motohelper.server.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);
    void save(User user);
    void delete(Long id);
    List<User> getAll();
}
