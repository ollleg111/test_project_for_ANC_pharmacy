package com.example.demo.dao;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.TwoStrings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class UrlDAO {
    List<TwoStrings> urlDAOList = new ArrayList<>();
    private final String alarmMessage = UrlDAO.class.getName();

    public void save(String originalString, String shortString) {
        log.info(originalString + " " + shortString + " was saved");
        urlDAOList.add(new TwoStrings(originalString, shortString));
    }

    public String getOriginalUrl(String shortUrl) throws NotFoundException {
        for(TwoStrings twoStrings : urlDAOList){
            if(twoStrings.getShortString().equals(shortUrl)) {
                return twoStrings.getOriginalString();
            }
        }
        throw  new NotFoundException("Wrong entered shortUrl: " + shortUrl +
                " from method getOriginalUrl(String shortUrl) from class "+ alarmMessage);
    }
}
