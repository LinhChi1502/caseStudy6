package com.case6.quizchallengeweb.model.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    public AppRole(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public AppRole() {

    }
}

