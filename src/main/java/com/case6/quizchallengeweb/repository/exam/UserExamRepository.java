package com.case6.quizchallengeweb.repository.exam;

import com.case6.quizchallengeweb.model.exam.UserExam;
import com.case6.quizchallengeweb.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExamRepository extends JpaRepository<UserExam, Long> {
    UserExam getUserExamById(Long id);

    List<UserExam> getAllByAppUserId(Long id);

    UserExam getByAppUserIdAndExamId(Long appUserId, Long examId);

 }
