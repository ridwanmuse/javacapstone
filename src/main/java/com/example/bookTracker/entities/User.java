package com.example.bookTracker.entities;

import com.example.bookTracker.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Books> noteSet = new HashSet<>();
    public User() {} //default constructor
    public User(UserDto userDto){
        if (userDto.getUsername() != null)
            this.username = userDto.getUsername();
        if (userDto.getPassword() != null)
            this.password = userDto.getPassword();
    }
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
}