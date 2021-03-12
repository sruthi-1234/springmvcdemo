package com.springmvcdemo.springmvcdemo.service;

import com.springmvcdemo.springmvcdemo.model.User;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Service
public interface UserService{
    void saveUser(User user);

    Iterable<User> showUsers();
    User findById(long id);
    Iterable<User> saveOrUpdate(User user, Long id);
    String deleteById(long id);
}
