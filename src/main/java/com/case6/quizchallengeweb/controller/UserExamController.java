package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.service.exam.exam.IExamService;
import com.case6.quizchallengeweb.service.exam.userexam.IUserExamService;
import com.case6.quizchallengeweb.service.question.useranswer.IUserAnswerService;
import com.case6.quizchallengeweb.service.user.appuser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/userexams")
public class UserExamController {

    @Autowired
    private IUserExamService userExamService;

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private IExamService examService;

    @Autowired
    private IUserAnswerService userAnswerService;
}
