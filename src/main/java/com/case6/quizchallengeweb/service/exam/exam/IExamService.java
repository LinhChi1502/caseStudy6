package com.case6.quizchallengeweb.service.exam.exam;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.service.IService;

import java.util.List;

public interface IExamService extends IService<Exam> {
    List<Exam> getAllExamByUserId(Long id);
    List<Exam> getAllExamByUserId(Long id);
    List<Exam> getAllTestedExams();
    int get50UpUserCountByExamId(Long id);
    int get50DownUserCountByExamId(Long id);
}
