package com.case6.quizchallengeweb.model.question;

import com.case6.quizchallengeweb.model.exam.UserExam;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private int questionIndex;

    @ManyToOne
    @JoinColumn(name = "userExam")
//    @JsonIgnore
    private UserExam userExam;
}
