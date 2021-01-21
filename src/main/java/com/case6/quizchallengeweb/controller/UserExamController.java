package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.exam.UserExam;
import com.case6.quizchallengeweb.model.question.UserAnswer;
import com.case6.quizchallengeweb.service.exam.exam.IExamService;
import com.case6.quizchallengeweb.service.exam.userexam.IUserExamService;
import com.case6.quizchallengeweb.service.question.useranswer.IUserAnswerService;
import com.case6.quizchallengeweb.service.user.appuser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/exam-list/{id}")
    public ResponseEntity<List<Exam>> getAllExamByUserId(@PathVariable Long id) {
        List<Exam> allExamByUserId = examService.getAllExamByUserId(id);
        return new ResponseEntity<>(allExamByUserId, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<UserExam>> getUserExamById(@PathVariable Long id) {
        List<UserExam> allUserExamByUserID = userExamService.getUserExamById(id);
        return new ResponseEntity<>(allUserExamByUserID, HttpStatus.OK);

    }

    @GetMapping("/mark/{id}")
    public ResponseEntity<Double> countMark(@PathVariable Long id) {
        Optional<UserExam> optionalUserExam = userExamService.findById(id);
        return optionalUserExam.map(userExam
                -> new ResponseEntity(userExamService.countMark(userExam.getAppUser(), userExam.getExam()), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<UserExam> saveNewUserExam(@RequestBody UserExam userExam){
//        userExam.setAppUser(this.appUserService.findById((long) 5).get());
        this.userExamService.save(userExam);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
