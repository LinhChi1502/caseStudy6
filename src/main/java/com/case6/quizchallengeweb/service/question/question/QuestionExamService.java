package com.case6.quizchallengeweb.service.question.question;

import com.case6.quizchallengeweb.model.exam.ExamQuestion;
import com.case6.quizchallengeweb.repository.question.QuestionExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class QuestionExamService implements IQuestionExamService {
    @Autowired
    private QuestionExamRepository questionExamRepository;
    @Override
    public Iterable<ExamQuestion> getAll() {
        return questionExamRepository.findAll();
    }

    @Override
    public ExamQuestion save(ExamQuestion examQuestion)
    {
        return questionExamRepository.save(examQuestion);
    }

    @Override
    public Optional<ExamQuestion> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
