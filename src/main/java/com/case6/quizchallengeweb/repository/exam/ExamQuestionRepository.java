package com.case6.quizchallengeweb.repository.exam;

import com.case6.quizchallengeweb.model.exam.ExamQuestion;
import com.case6.quizchallengeweb.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, Long> {
    List<ExamQuestion> getAllByExamId(Long id);
}
