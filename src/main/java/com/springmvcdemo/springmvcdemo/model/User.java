package com.springmvcdemo.springmvcdemo.model;
import javax.persistence.Column;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;
    @Column
    private String email;

    public User() {

    }
}
