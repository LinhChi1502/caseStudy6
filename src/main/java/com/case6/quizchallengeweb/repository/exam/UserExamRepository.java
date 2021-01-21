package com.case6.quizchallengeweb.repository.exam;

import com.case6.quizchallengeweb.model.exam.UserExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExamRepository extends JpaRepository<UserExam, Long> {
    List<UserExam> getAllByAppUserId(Long id);

    UserExam getByAppUserIdAndExamId(Long appUserId, Long examId);

    List<UserExam> getAllByExamId(Long id);
}
