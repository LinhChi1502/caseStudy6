package com.case6.quizchallengeweb.service.exam.userexam;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.exam.UserExam;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.repository.exam.UserExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserExamService implements IUserExamService {

    @Autowired
    private UserExamRepository userExamRepository;

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
        userExamRepository.deleteById(id);
    }

    @Override
    public List<UserExam> getAllByAppUserId(Long id) {
        return userExamRepository.getAllByAppUserId(id);
    }
}
