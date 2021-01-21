package com.case6.quizchallengeweb.service.exam.exam;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.exam.ExamQuestion;
import com.case6.quizchallengeweb.model.exam.UserExam;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.repository.exam.ExamRepository;
import com.case6.quizchallengeweb.repository.exam.UserExamRepository;
import com.case6.quizchallengeweb.repository.question.QuestionExamRepository;
import com.case6.quizchallengeweb.service.exam.userexam.IUserExamService;
import com.case6.quizchallengeweb.service.question.useranswer.IUserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ExamService implements IExamService {

    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private UserExamRepository userExamRepository;
    @Autowired
    private QuestionExamRepository questionExamRepository;
    @Autowired
    private IUserExamService userExamService;

    @Override
    public Iterable<Exam> getAll() {
        return examRepository.findAll();
    }

    @Override
    public Exam save(Exam exam) {
//        List<Exam> all = examRepository.findAll();
//        Exam exam1 = all.get(all.size() - 1);
//       long newId= exam1.getId()+1;
//        exam.setId(newId);
//        List<Question> questionList=new ArrayList<>();
//
//        Set<ExamQuestion> examQuestions = exam.getExamQuestions();
//
//        for (ExamQuestion examQuestion :examQuestions
//             ) {
//          questionList.add(examQuestion.getQuestion());
//        }
//        for (ExamQuestion examQuestion : examQuestions
//        ) {
//            examQuestion.setExam(exam);
//            questionExamRepository.save(examQuestion);
//
//        }

        examRepository.save(exam);

        return examRepository.save(exam);
    }

    @Override
    public Optional<Exam> findById(Long id) {
        return examRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        examRepository.deleteById(id);
    }

    @Override
    public List<Exam> getAllExamByUserId(Long id) {
        List<UserExam> allUserExams = userExamRepository.getAllByAppUserId(id);
        List<Exam> examList = new ArrayList<>();
        for (UserExam userExam:
                allUserExams) {
            examList.add(userExam.getExam());
        }
        return examList;
    }


    @Override
    public List<Exam> getAllTestedExams() {
        //        Iterable<Exam> allExams = this.getAll();
        List<Exam> allExams = examRepository.findAll();
        List<Exam> allTestedExams = new ArrayList<>();
        for (Exam exam : allExams) {
            List<UserExam> allUserExams = userExamService.getAllByExamId(exam.getId());
            if (allUserExams.size() > 0) {
                allTestedExams.add(exam);
            }
        }
        return allTestedExams;
    }

    @Override
    public int get50UpUserCountByExamId(Long id) {
        int result = 0;
        List<UserExam> allUserExams = userExamService.getAllByExamId(id);
        for (UserExam userExam :
                allUserExams) {
            double mark = userExamService.countMark(userExam.getAppUser(), userExam.getExam());
            if (mark > 50) {
                result += 1;
            }
        }
        return result;
    }

    @Override
    public int get50DownUserCountByExamId(Long id) {
        int result = 0;
        List<UserExam> allUserExams = userExamService.getAllByExamId(id);
        for (UserExam userExam :
                allUserExams) {
            double mark = userExamService.countMark(userExam.getAppUser(), userExam.getExam());
            if (mark <= 50) {
                result += 1;
            }
        }
        return result;
    }
}
