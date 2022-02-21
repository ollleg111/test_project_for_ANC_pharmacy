package com.example.demo.service;

import com.example.demo.dao.UrlDAO;
import com.example.demo.exceptions.BedRequestException;
import com.example.demo.util.Utils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Controller;

@Slf4j
@AllArgsConstructor
@Controller
public class UrlService {
    private final UrlDAO urlDAO;
    private final String alarmMessage = UrlService.class.getName();

    public String getShortUrlString(String originalString) {
//        validation(originalString);
/*
        TwoStrings twoStrings = urlDAO.getObject(originalString);
        if (Objects.nonNull(twoStrings)) return twoStrings.getShortString();
*/
        String shortString = Utils.stringGenerator();
        urlDAO.save(originalString, shortString);
        return shortString;
    }

    public String getOriginalUrl(String shortUrl) {
        return urlDAO.getOriginalUrl(shortUrl);
    }

    public void validation(String originalString) throws BedRequestException {
        final UrlValidator urlValidator = new UrlValidator();
        if (!urlValidator.isValid(originalString)) throw
                new BedRequestException(" Status 404: Invalid URL in method" +
                        " validation(String originalString) from class " + alarmMessage);
    }
}
