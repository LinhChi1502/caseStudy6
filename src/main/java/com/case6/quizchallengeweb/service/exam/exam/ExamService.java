package com.case6.quizchallengeweb.service.exam.exam;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.exam.ExamQuestion;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.repository.exam.ExamRepository;
import com.case6.quizchallengeweb.repository.question.QuestionExamRepository;
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
    private QuestionExamRepository questionExamRepository;

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
}
