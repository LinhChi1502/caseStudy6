package com.case6.quizchallengeweb.service.question.useranswer;

import com.case6.quizchallengeweb.model.question.Answer;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.model.question.UserAnswer;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.service.IService;

import java.util.List;

public interface IUserAnswerService extends IService<UserAnswer> {
    void saveArrayUserAnswer(Iterable<UserAnswer> arr);
    List<UserAnswer> getAllUserAnswer(AppUser appUser, Long examId);

}
