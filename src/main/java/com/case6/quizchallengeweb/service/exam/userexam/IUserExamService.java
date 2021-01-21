package com.case6.quizchallengeweb.service.exam.userexam;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.exam.UserExam;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.service.IService;

import java.util.List;

public interface IUserExamService extends IService<UserExam> {
    List<UserExam> getAllByAppUserId(Long id);

    UserExam getByAppUserIdAndExamId(Long appUserId, Long examId);

    double countMark(AppUser appUser, Exam exam);

    List<UserExam> getAllByExamId(Long id);

    List<UserExam> getAllById(Long id);


}
