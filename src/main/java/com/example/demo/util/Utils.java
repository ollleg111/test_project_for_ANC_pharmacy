package com.example.demo.util;

import com.example.demo.exceptions.BedRequestException;
import com.example.demo.models.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;

@Slf4j
public class Utils {
    public static void loginValidation(HttpSession session) throws BedRequestException {
        User user = (User) session.getAttribute("user");
        if (user == null) throw
                new BedRequestException(" Status 404: You must write the login ");
    }
}