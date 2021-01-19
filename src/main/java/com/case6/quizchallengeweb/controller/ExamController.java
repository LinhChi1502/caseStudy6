package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.model.exam.Exam;
import com.case6.quizchallengeweb.model.question.Category;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.service.exam.exam.IExamService;
import com.case6.quizchallengeweb.service.exam.userexam.IUserExamService;
import com.case6.quizchallengeweb.service.question.question.IQuestionService;
import com.case6.quizchallengeweb.service.user.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/exams")
public class ExamController {
    @Autowired
    private IExamService examService;

    @Autowired
    private IQuestionService questionService;
    

    @GetMapping
    public ResponseEntity<Iterable<Exam>> findAllExams(){
        return new ResponseEntity<>(examService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExam(@PathVariable Long id) {
        Optional<Exam> optionalExam = examService.findById(id);
        return optionalExam.map(exam -> new ResponseEntity<>(exam,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Exam> saveExam(@RequestBody Exam exam){
        examService.save(exam);

        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

}
