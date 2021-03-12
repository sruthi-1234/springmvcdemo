package com.springmvcdemo.springmvcdemo.service;

import com.springmvcdemo.springmvcdemo.model.User;
import com.springmvcdemo.springmvcdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserServiceImpl implements UserService
{
    @Autowired
    public UserRepository repo;


    @Override
    public void saveUser(User user) {
        // TODO Auto-generated method stub
        repo.save(user);
    }

    @Override
    public Iterable<User> showUsers() {
        // TODO Auto-generated method stub
        Iterable<User> list = repo.findAll();
        return list;
    }

    @Override
    public Iterable<User> saveOrUpdate(User user, Long id) {
        // TODO Auto-generated method stub
        return (Iterable<User>) repo.save(user);
    }

    @Override
    public User findById(long id) {
        // TODO Auto-generated method stub
        Optional<User> user=repo.findById(id);
        return user.orElse(null);
    }

    @Override
    public String deleteById(long id) {
        // TODO Auto-generated method stub
        Optional<User> user=repo.findById(id);
        repo.deleteById(id);
        return "successfully deleted";
    }

}
