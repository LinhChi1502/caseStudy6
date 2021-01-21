package com.case6.quizchallengeweb.model.exam;

import com.case6.quizchallengeweb.model.question.UserAnswer;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class UserExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UpdateTimestamp
    private Date date;

    @ManyToOne
    @JoinColumn(name = "appUser_id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @JsonIgnore
    @OneToMany(mappedBy = "userExam",fetch = FetchType.EAGER)
    private Set<UserAnswer> userAnswers;
}
