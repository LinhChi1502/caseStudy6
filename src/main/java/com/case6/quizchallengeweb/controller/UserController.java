package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.model.question.Answer;
import com.case6.quizchallengeweb.model.user.AppRole;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.service.user.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    AppUserService appUserService;

    @GetMapping
    public ResponseEntity<Iterable<AppUser>> findAllUser() {
        return new ResponseEntity<>(appUserService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUser> addUser(@PathVariable Long id, @RequestBody AppUser appUser) {
        Optional<AppUser> optionalAppUser = appUserService.findById(id);
        return optionalAppUser.map(appUser1 -> {
            appUser.setId(appUser1.getId());
            AppRole appRole = new AppRole();
            appRole.setId(2L);
            Set<AppRole> appRoles = appUser.getRoles();
            appRoles.add(appRole);
            appUser.setRoles(appRoles);
            return new ResponseEntity<>(appUserService.save(appUser), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
        Optional<AppUser> optionalAppUser = appUserService.findById(id);
        return optionalAppUser.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}