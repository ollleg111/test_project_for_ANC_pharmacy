package com.example.demo.dao;

import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDAO {
    List<User> userList= new ArrayList<>();

    public void save(User user) {
        userList.add(user);
    }

    public User getUser(String mail, String password) {
            return userList.stream().
               filter(m -> m.getMail().equals(mail)).
               filter(p -> p.getPassword().equals(password)).
               collect(Collectors.toList()).get(0);
    }
}
