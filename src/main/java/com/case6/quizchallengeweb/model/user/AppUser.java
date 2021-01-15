package com.case6.quizchallengeweb.model.user;

import com.case6.quizchallengeweb.model.exam.UserExam;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String fullname;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> roles;

    @OneToMany
    private Set<UserExam> userExams;
}
