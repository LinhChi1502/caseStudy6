package com.case6.quizchallengeweb.model.question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotBlank(message = "Name is mandatory")
    @Column(unique = true, name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Question> questions;
}
