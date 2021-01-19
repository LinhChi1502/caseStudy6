package com.case6.quizchallengeweb.model.exam;

import com.case6.quizchallengeweb.model.question.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "exam_question")
public class ExamQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "examid")
    private Exam exam  ;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questid")
    private Question question  ;
}
