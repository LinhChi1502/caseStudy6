package com.case6.quizchallengeweb.model.user;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String username;
    private String fullname;
    private Collection<? extends GrantedAuthority> roles;


    public JwtResponse(String token, String username, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }

    public JwtResponse(String jwt, Long id, String username, Collection<? extends GrantedAuthority> authorities) {
        this.token = jwt;
        this.id = id;
        this.username= username;
        this.roles=authorities;

    }

    public JwtResponse(Long id, String token, String type, String username, String fullname, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.token = token;
        this.type = type;
        this.username = username;
        this.fullname = fullname;
        this.roles = roles;
    }
}
