package com.example.demo.controller;

import com.example.demo.service.UrlService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping(value ="/toShort")
    public ResponseEntity<String> toShortUrl(HttpSession session,
                                             @RequestParam("url") String url) {
        loginValidation(session);
        log.info("In method toShortUrl entered url: " + url);
        String shortUrl = urlService.getShortUrlString(url);
        return new ResponseEntity<>(shortUrl, HttpStatus.OK);
    }

    @GetMapping(value = "/getOriginal", produces = "application/json")
    public ResponseEntity<String> getOriginalUrl(HttpSession session,
                                                 @RequestParam("url") String url) {
        loginValidation(session);
        log.info("In method getOriginalUrl entered url: " + url);
        String originalUrl = urlService.getOriginalUrl(url);
        log.info("In method getOriginalUrl we have back url: " + originalUrl);
        return new ResponseEntity<>(originalUrl, HttpStatus.OK);
    }
}
