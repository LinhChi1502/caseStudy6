package com.case6.quizchallengeweb.service.question.question;

import com.case6.quizchallengeweb.model.question.Category;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.service.IService;

import java.util.List;

public interface IQuestionService extends IService<Question> {
    List<Question> findAllQuestionByCategory_Id(Category category);

    Question disableQuestion(long id);

    Question updateQuestion(long id,Question question);

    List<Question> getAllQuestByTypeIsAndCategoryIsAndTitleContaining(String type, String Category, String title);

    List<Question> getAllQuestionByExamId(Long id);


//    Iterable<Question> getAllQuestByTitleContaining(String title);
//
//    Iterable<Question> getAllQuestByType_NameAndTitleContaining(String type, String title);
//
//    Iterable<Question> getAllQuestByCategory_NameAndTitleContaining(String Category, String title);
}
