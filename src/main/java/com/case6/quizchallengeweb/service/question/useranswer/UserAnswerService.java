package com.case6.quizchallengeweb.service.question.useranswer;

import com.case6.quizchallengeweb.model.question.Answer;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.model.question.UserAnswer;
import com.case6.quizchallengeweb.repository.question.UserAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAnswerService implements IUserAnswerService {

    @Autowired
    private UserAnswerRepository userAnswerRepository;

    @Override
    public Iterable<UserAnswer> getAll() {
        return userAnswerRepository.findAll();
    }

    @Override
    public UserAnswer save(UserAnswer userAnswer) {
        return userAnswerRepository.save(userAnswer);
    }

    @Override
    public Optional<UserAnswer> findById(Long id) {
        return userAnswerRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        userAnswerRepository.deleteById(id);
    }

    @Override
    public void saveArrayUserAnswer(Iterable<UserAnswer> arr){
            this.userAnswerRepository.saveAll(arr);
    }

}
