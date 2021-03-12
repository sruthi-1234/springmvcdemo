package com.springmvcdemo.springmvcdemo.repository;

import com.springmvcdemo.springmvcdemo.model.User;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
