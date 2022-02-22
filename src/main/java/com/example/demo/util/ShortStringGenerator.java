package com.example.demo.util;

import com.example.demo.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import java.security.SecureRandom;
import java.util.Locale;

@Slf4j
public class ShortStringGenerator {
    public String stringGenerator() {
        int urlLength = Constants.SHORT_URL_LENGTH;
        String upper = Constants.UPPER;
        String lower = upper.toLowerCase(Locale.ROOT);
        String digits = Constants.DIGITS;

        String alphabet = upper + lower + digits;
        SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(urlLength);
        for (int i = 0; i < urlLength; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return Constants.BACK_STRING_UPPER.concat(sb.toString());
    }
}
