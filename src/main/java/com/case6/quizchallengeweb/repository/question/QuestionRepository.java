package com.case6.quizchallengeweb.repository.question;

import com.case6.quizchallengeweb.model.question.Category;
import com.case6.quizchallengeweb.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Iterable<Question> getAllByCategoryIs(Category category);

    Iterable<Question> getAllByType_NameAndCategory_NameAndTitleContaining(String type, String Category, String title);

    Iterable<Question> getAllByTitleContaining(String title);

    Iterable<Question> getAllByType_NameAndTitleContaining(String type, String title);

    Iterable<Question> getAllByCategory_NameAndTitleContaining(String Category, String title);





}
