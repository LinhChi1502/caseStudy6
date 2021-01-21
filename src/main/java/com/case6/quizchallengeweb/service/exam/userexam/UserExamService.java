package com.case6.quizchallengeweb.service.exam.userexam;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.exam.ExamQuestion;
import com.case6.quizchallengeweb.model.exam.UserExam;
import com.case6.quizchallengeweb.model.question.Answer;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.model.question.UserAnswer;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.repository.exam.UserExamRepository;
import com.case6.quizchallengeweb.repository.question.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserExamService implements IUserExamService {

    @Autowired
    private UserExamRepository userExamRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Iterable<UserExam> getAll() {
        return userExamRepository.findAll();
    }

    @Override
    public UserExam save(UserExam userExam) {
        return userExamRepository.save(userExam);
    }

    @Override
    public Optional<UserExam> findById(Long id) {
        return userExamRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        userExamRepository.deleteUserExamById(id);
    }

    @Override
    public UserExam getUserExamById(Long id) {
        return userExamRepository.getUserExamById(id);
    }

    @Override
    public UserExam getByAppUserIdAndExamId(Long appUserId, Long examId) {
        return userExamRepository.getByAppUserIdAndExamId(appUserId, examId);
    }

    @Override
    public List<UserExam> getAllByAppUserId(Long id){
        return userExamRepository.getAllByAppUserId(id);
    }

    @Override
    public double countMark(AppUser appUser, Exam exam) {
        UserExam userExam = userExamRepository.getByAppUserIdAndExamId(appUser.getId(), exam.getId());
        Set<UserAnswer> userAnswers = userExam.getUserAnswers();

        List<UserAnswer> userAnswerList = new ArrayList<>(userAnswers);

        double mark = 0;
        List<Question> questions = new ArrayList<>();

        Set<ExamQuestion> examQuestions = exam.getExamQuestions();
        for (ExamQuestion examQuestion : examQuestions) {
            questions.add(examQuestion.getQuestion());
        }

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            List<Answer> correctAnswers = answerRepository.getAllByQuestionAndCorrect(question, true);

            if (question.getType().getId() == 1 || question.getType().getId() == 2) {
                for (UserAnswer userAnswer : userAnswerList) {
                    if (userAnswer.getQuestionIndex() == question.getId() && userAnswer.getContent().equalsIgnoreCase(correctAnswers.get(0).getContent())) {
                        mark += 1;
                    }
                }
            }

            if (question.getType().getId() == 4) {
                int userTrueAnswerCount = 0;
                int correctAnswerCount = correctAnswers.size();
                for (UserAnswer userAnswer : userAnswerList) {
                    if (userAnswer.getQuestionIndex() == question.getId()) {
                        for (Answer answer : correctAnswers) {
                            if (userAnswer.getContent().equalsIgnoreCase(answer.getContent())) {
                                userTrueAnswerCount += 1;
                            }
                        }
                    }
                }
                mark += (userTrueAnswerCount / correctAnswerCount);
            }

            if (question.getType().getId() == 3) {
                for (UserAnswer userAnswer : userAnswerList) {
                    if (userAnswer.getQuestionIndex() == question.getId()) {
                        for (Answer answer : correctAnswers) {
                            if (userAnswer.getContent().equalsIgnoreCase(answer.getContent())) {
                                mark+=1;
                            }
                        }
                    }
                }
            }

        }

        int questionSize = questions.size();
        return Math.round(mark/questionSize * 100);
    }
}
