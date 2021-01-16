package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.model.user.AppRole;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.service.user.approle.IAppRoleService;
import com.case6.quizchallengeweb.service.user.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/roles")
public class AppRoleController {
    @Autowired
    IAppRoleService appRoleService;

    @GetMapping
    public ResponseEntity<Iterable<AppRole>> findAllRole(){
        return new ResponseEntity<>(appRoleService.getAll(), HttpStatus.OK);
    }
}
