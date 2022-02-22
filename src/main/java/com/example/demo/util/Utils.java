package com.example.demo.util;

import com.example.demo.exceptions.BedRequestException;
import com.example.demo.models.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;

@Slf4j
public class Utils {
public static void loginValidation(HttpSession session) throws BedRequestException {
    User user = (User) session.getAttribute("user");
    String stringUserId = String.valueOf(user.getId());
    isUserWithLogin(session, stringUserId);
}

    public static void isUserWithLogin(HttpSession session, String userId) throws BedRequestException {
        User user = (User) session.getAttribute("user");
        if(user == null || !String.valueOf(user.getId()).equals(userId)) throw new
                BedRequestException(" Status 400: Incorrect password or login" );
    }
}