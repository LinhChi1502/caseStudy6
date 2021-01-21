package com.case6.quizchallengeweb.service.exam.examquestion;

import com.case6.quizchallengeweb.model.exam.ExamQuestion;
import com.case6.quizchallengeweb.repository.exam.ExamQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamQuestionService implements IExamQuestionService {

    @Autowired
    private ExamQuestionRepository examQuestionRepository;

    @Override
    public Iterable<ExamQuestion> getAll() {
        return examQuestionRepository.findAll();
    }

    @Override
    public ExamQuestion save(ExamQuestion examQuestion) {
        return examQuestionRepository.save(examQuestion);
    }

    @Override
    public Optional<ExamQuestion> findById(Long id) {
        return examQuestionRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        examQuestionRepository.deleteById(id);
    }

    @Override
    public List<ExamQuestion> getAllByExamId(Long id) {
        return examQuestionRepository.getAllByExamId(id);
    }
}
