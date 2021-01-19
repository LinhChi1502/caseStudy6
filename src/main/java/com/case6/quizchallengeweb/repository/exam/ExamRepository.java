package com.case6.quizchallengeweb.repository.exam;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.question.Question;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> getAllExamByUserId(Long id);
}
