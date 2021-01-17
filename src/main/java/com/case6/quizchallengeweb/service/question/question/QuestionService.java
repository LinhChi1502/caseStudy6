package com.case6.quizchallengeweb.service.question.question;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.exam.ExamQuestion;
import com.case6.quizchallengeweb.model.question.Answer;
import com.case6.quizchallengeweb.model.question.Category;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.repository.exam.ExamRepository;
import com.case6.quizchallengeweb.repository.question.AnswerRepository;
import com.case6.quizchallengeweb.repository.question.CategoryRepository;
import com.case6.quizchallengeweb.repository.question.QuestionRepository;
import org.hibernate.annotations.AttributeAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ExamRepository examRepository;

    @Override
    public Iterable<Question> getAll() {
        return questionRepository.findAll();
    }


    @Override
    public Question save(Question question) {
        Set<Answer> answers = question.getAnswers();

        for (Answer answer : answers
        ) {
            answer.setQuestion(question);

        }
        questionRepository.save(question);
        for (Answer answer : answers
        ) {
            answerRepository.save(answer);
        }
        return questionRepository.save(question);

    }


    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> findAllQuestionByCategory_Id(Category category) {
        Iterable<Question> questions1 = questionRepository.getAllByCategoryIs(category);
        List<Question> questions2 = new ArrayList<>();
        for (Question question : questions1
        ) {
            questions2.add(question);
        }
        return questions2;
    }

    @Override
    public Question disableQuestion(long id) {
        Question disableQuestion = questionRepository.findById(id).get();
        if (disableQuestion.getExamQuestions().size() == 0) {
            disableQuestion.setActive(false);
            questionRepository.save(disableQuestion);
            return disableQuestion;
        } else return null;
    }

    @Override
    public Question updateQuestion(long id, Question question1) {
        List<Question> questions = questionRepository.findAll();
        Question question = questionRepository.findById(id).get();
        if (questions.contains(question)) {
            question1.setId(id);
            questionRepository.save(question1);
            return question1;
        }
        return null;
    }

    @Override
    public List<Question> getAllQuestByTypeIsAndCategoryIsAndTitleContaining(String type, String category, String title) {
        Iterable<Question> questions;
        if (!type.equals("") && !category.equals("")) {
            questions = questionRepository.getAllByType_NameAndCategory_NameAndTitleContaining(type, category, title);
        } else if (type.equals("") && category.equals("")) {
            questions = questionRepository.getAllByTitleContaining(title);
        } else if (!type.equals("")) {
            questions = questionRepository.getAllByType_NameAndTitleContaining(type, title);
        } else {
            questions = questionRepository.getAllByCategory_NameAndTitleContaining(category, title);
        }

        List<Question> questionsList = new ArrayList<>();
        for (Question question : questions
        ) {
            questionsList.add(question);
        }
        return questionsList;


    }

    @Override
    public List<Question> getAllQuestionByExamId(Long id) {
        Exam exam = examRepository.findById(id).get();

        List<Question> questions = new ArrayList<>();
        Set<ExamQuestion> examQuestions = exam.getExamQuestions();
        for (ExamQuestion examQuestion : examQuestions
        ) {
            questions.add(examQuestion.getQuestion());
        }
        return questions;
    }


}
