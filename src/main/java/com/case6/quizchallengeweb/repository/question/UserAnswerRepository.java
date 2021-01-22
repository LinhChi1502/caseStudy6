package com.case6.quizchallengeweb.repository.question;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.question.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
    List<UserAnswer> getAllByUserExam_AppUser_IdAndUserExam_Exam(Long user, Exam id);
    List<UserAnswer> getUserAnswersByUserExamId(Long id);
}
