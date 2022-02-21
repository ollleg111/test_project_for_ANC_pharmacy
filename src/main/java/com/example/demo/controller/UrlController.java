package com.example.demo.controller;

import com.example.demo.service.UrlService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.example.demo.util.Utils.loginValidation;

@Slf4j
@AllArgsConstructor
@RequestMapping("/url")
@Controller
public class UrlController {
    private final UrlService urlService;
    private final static Logger logger = Logger.getLogger(UrlController.class);

    @PostMapping(value ="/toShort")
    public ResponseEntity<String> toShortUrl(HttpSession session,
                                             @RequestParam("url") String url) {
        //loginValidation(session);
        log.info("Entered url: " + url);
        logger.info("Entered url: " + url);
        String shortUrl = urlService.getShortUrlString(url);
        logger.info("Returned url: " + shortUrl);
        return new ResponseEntity<>(shortUrl, HttpStatus.OK);
    }

    @GetMapping(value = "/getOriginal", produces = "application/json")
    public ResponseEntity<String> getOriginalUrl(HttpSession session,
                                                 @RequestParam("url") String url) {
        //loginValidation(session);
        log.info("Entered url: " + url);
        logger.info("Entered url: " + url);
        String originalUrl = urlService.getOriginalUrl(url);
        logger.info("Returned url: " + originalUrl);
        return new ResponseEntity<>(originalUrl, HttpStatus.OK);
    }
}
