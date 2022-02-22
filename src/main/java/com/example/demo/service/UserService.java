package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.exceptions.BedRequestException;
import com.example.demo.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserDAO userDAO;
    private final String alarmMessage = UserService.class.getName();

    public void save(User user) {
        validate(user);
        userDAO.save(user);
    }

    public User login(String mail, String password) throws BedRequestException {
        if (mail.isEmpty() || password.isEmpty())
            throw new BedRequestException(" Status 404: Incorrect email or password ");

        User user = userDAO.getUser(mail, password);
        if (user == null)
            throw new BedRequestException(" Status 404: User with email or password does not exist ");
        return user;
    }

    private void validate(User user) throws BedRequestException {
        if(user.getName() == null || user.getName().isEmpty())
            throw new BedRequestException(" Status 404: Wrong user name in method " +
                    "validate(User user) from class " + alarmMessage);

        if(user.getMail() == null || user.getMail().isEmpty())
            throw new BedRequestException(" Status 404: Wrong user email in method " +
                    "validate(User user) from class " + alarmMessage);

        if(user.getPassword() == null || user.getPassword().isEmpty())
            throw new BedRequestException(" Status 404: Wrong user password in method " +
                    "validate(User user) from class " + alarmMessage);
    }
}

