package com.case6.quizchallengeweb.repository.question;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.question.UserAnswer;
import com.case6.quizchallengeweb.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
    List<UserAnswer> findAllByUserExam_AppUserAndUserExam_Id(AppUser currentUser, Long examId);
    List<UserAnswer>getAllByUserExam_Id(Long id);
    List<UserAnswer>getAllByUserExam_AppUser_IdAndUserExam_Exam(Long user, Exam id);
}
