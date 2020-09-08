package com.motohelper.server.service;

import com.motohelper.server.model.User;
import com.motohelper.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    UserRepository repository;


    @Override
    public User getById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void save(User user) {
        repository.saveAndFlush(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
