package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.model.question.Answer;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.service.user.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    AppUserService appUserService;

    @GetMapping
    public ResponseEntity<Iterable<AppUser>> findAllUser(){
        return new ResponseEntity<>(appUserService.getAll(), HttpStatus.OK);
    }
}
