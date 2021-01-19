package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.exam.UserExam;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.service.exam.exam.IExamService;
import com.case6.quizchallengeweb.service.exam.userexam.IUserExamService;
import com.case6.quizchallengeweb.service.question.useranswer.IUserAnswerService;
import com.case6.quizchallengeweb.service.user.appuser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/userexams")
public class UserExamController {
    @Autowired
    private IUserExamService userExamService;
    @Autowired
    private IAppUserService appUserService;
    @Autowired
    private IExamService examService;
    @Autowired
    private IUserAnswerService userAnswerService;
    @GetMapping
    public ResponseEntity<Iterable<UserExam>> getAllUserExam() {
        Iterable<UserExam> all = userExamService.getAll();
        return new ResponseEntity<>(all, HttpStatus.ACCEPTED);
    }

    @GetMapping("/examlist/{id}")
    public ResponseEntity<List<Exam>> getAllExamByUserId(@PathVariable Long id) {
        List<Exam> examList = examService.getAllExamByUserId(id);
        return new ResponseEntity<>(examList, HttpStatus.OK);
    }

}
