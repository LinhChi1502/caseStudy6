package com.case6.quizchallengeweb.model.question;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.exam.ExamQuestion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;



    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
    private Set<Answer> answers;

    @JsonIgnore
    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY)
    private Set<ExamQuestion> examQuestions;
}
