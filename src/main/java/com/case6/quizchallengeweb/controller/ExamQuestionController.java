package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.exam.ExamQuestion;
import com.case6.quizchallengeweb.service.question.question.QuestionExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/examquest")
public class ExamQuestionController {

    @Autowired
    private QuestionExamService questionExamService;

    @GetMapping
    public ResponseEntity<Iterable<ExamQuestion>> findAllExams(){
        return new ResponseEntity<>(questionExamService.getAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ExamQuestion> saveExams(@RequestBody ExamQuestion examQuestion){

        return new ResponseEntity<>(  questionExamService.save(examQuestion), HttpStatus.OK);
    }
}
