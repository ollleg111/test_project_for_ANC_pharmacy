package com.example.demo.util;

import com.example.demo.constants.*;
import com.example.demo.exceptions.BedRequestException;
import com.example.demo.models.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Locale;

@Slf4j
public class Utils {
    public static Long stringToLong(String number) throws BedRequestException {
        try {
            long id = Long.parseLong(number);
            if (id <= 0) {
                throw new BedRequestException(" Status 404: Wrong entered number: " + number);
            }
            return id;
        } catch (NumberFormatException e) {
            throw new BedRequestException(" Status 404: Incorrect format ");
        }
    }

    public static String stringGenerator() {

        int urlLength = Constants.SHORT_URL_LENGTH;
        String upper = Constants.UPPER;
        String lower = upper.toLowerCase(Locale.ROOT);
        String digits = Constants.DIGITS;

        String alphabet = upper + lower + digits;
        SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(urlLength);
        for (int i = 0; i < urlLength; i++) {
            String s = sb.append(alphabet.charAt(random.nextInt(alphabet.length()))).toString();
        }
        return sb.toString();
    }

    public static void loginValidation(HttpSession session) throws BedRequestException {
        isUserWithLogin(session, ((User) session.getAttribute("user")).getName());
    }

    public static void isUserWithLogin(HttpSession session, String userName) throws BedRequestException {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getName().equals(userName)) throw
                new BedRequestException(" Status 404: You must write the login");
    }
}