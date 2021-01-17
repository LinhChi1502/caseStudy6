package com.case6.quizchallengeweb.repository.exam;

import com.case6.quizchallengeweb.model.exam.UserExam;
import com.case6.quizchallengeweb.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExamRepository extends JpaRepository<UserExam, Long> {

}
