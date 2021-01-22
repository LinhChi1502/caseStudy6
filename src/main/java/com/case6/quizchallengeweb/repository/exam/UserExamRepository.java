package com.case6.quizchallengeweb.repository.exam;

import com.case6.quizchallengeweb.model.exam.UserExam;
import com.case6.quizchallengeweb.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExamRepository extends JpaRepository<UserExam, Long> {

    List<UserExam> getAllByExamId(Long id);
    List<UserExam> getAllByAppUserId(Long id);

    UserExam getByAppUserIdAndExamId(Long appUserId, Long examId);

    void deleteUserExamById(Long id);

    List<UserExam> getAllById(Long id);

    UserExam getUserExamById(Long id);
}
