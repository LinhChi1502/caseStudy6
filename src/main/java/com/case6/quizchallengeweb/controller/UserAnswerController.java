package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.model.question.UserAnswer;
import com.case6.quizchallengeweb.service.question.useranswer.IUserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/useranswer")
public class UserAnswerController {
    @Autowired
    private IUserAnswerService userAnswerService;

    @PostMapping
    public ResponseEntity<UserAnswer> saveResult(@RequestBody Iterable<UserAnswer> userAnswers){
        this.userAnswerService.saveArrayUserAnswer(userAnswers);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
