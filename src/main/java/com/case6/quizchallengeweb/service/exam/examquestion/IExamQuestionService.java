package com.case6.quizchallengeweb.service.exam.examquestion;

import com.case6.quizchallengeweb.model.exam.ExamQuestion;
import com.case6.quizchallengeweb.service.IService;

import java.util.List;

public interface IExamQuestionService extends IService<ExamQuestion> {
    List<ExamQuestion> getAllByExamId(Long id);

}
