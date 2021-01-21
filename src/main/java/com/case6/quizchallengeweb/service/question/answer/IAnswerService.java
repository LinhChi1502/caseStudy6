package com.case6.quizchallengeweb.service.question.answer;

import com.case6.quizchallengeweb.model.question.Answer;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.service.IService;

import java.util.List;

public interface IAnswerService extends IService<Answer> {
    List<Answer> getAllByQuestionAndCorrect(Question question, boolean isCorrect);

}
