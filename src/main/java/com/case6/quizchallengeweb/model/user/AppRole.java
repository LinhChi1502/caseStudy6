package com.case6.quizchallengeweb.model.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "appRole")
    private Set<AppUser> appUsers;

}
