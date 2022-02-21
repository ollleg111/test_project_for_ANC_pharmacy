package com.example.demo.controller;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@AllArgsConstructor
@RequestMapping("/users")
@Controller
public class UserController {
    private final UserService userService;
    private final static Logger logger = Logger.getLogger(UserController.class);

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerUser(
            @RequestParam("name") String name,
            @RequestParam("mail") String mail,
            @RequestParam("pass") String pass) {
        User user = new User();
            user.setName(name);
            user.setMail(mail);
            user.setPassword(pass);
        userService.save(user);
        log.info("Register user with data: " + user.getName() + " and " + user.getMail());
        logger.info("Register user with data: " + user.getName() + " and " + user.getMail());
        return new ResponseEntity(" User was saved ", HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(
            HttpSession session,
            @RequestParam("mail") String mail,
            @RequestParam("pass") String password)
    {
            User user = userService.login(mail, password);
            session.setAttribute("user", user);
            log.info(" login complete ");
            logger.info(" login complete ");
            return new ResponseEntity<>(" login complete ", HttpStatus.OK);
    }

    @GetMapping(path = "/logout")
    public ResponseEntity<String> logout(HttpSession session)
    {
            session.invalidate();
            log.info("logout complete");
            logger.info("logout complete");
            return new ResponseEntity<>("logout complete", HttpStatus.OK);
    }
}
