package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.model.question.Category;
import com.case6.quizchallengeweb.model.question.Question;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.service.question.answer.IAnswerService;
import com.case6.quizchallengeweb.service.question.question.IQuestionService;
import com.case6.quizchallengeweb.service.user.appuser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IAnswerService answerService;
    @Autowired
    private IAppUserService userService;

    @ModelAttribute("user")
    public AppUser user() {
        return userService.getCurrentUser();
    }

    @GetMapping
    public ResponseEntity<Iterable<Question>> findAllQuestion() {
        return new ResponseEntity<>(questionService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Question> disableQuestion(@PathVariable Long id) {
        Question disableQuestion = questionService.findById(id).get();

        if (disableQuestion.getExamQuestions().size() == 0) {
            disableQuestion.setActive(false);
            questionService.save(disableQuestion);
            return new ResponseEntity<>(disableQuestion, HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<Question> insertQuestion(@RequestBody Question question) {
        Question insertQuestion = questionService.save(question);
        return new ResponseEntity<>(insertQuestion, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> editQuestion(@PathVariable Long id, @RequestBody Question question) {
        Optional<Question> optionalQuestion = questionService.findById(id);
        return optionalQuestion.map(question1 -> {
            question.setId(question1.getId());
            return new ResponseEntity<>(questionService.save(question), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/search")
    public ResponseEntity<List<Question>> searchQuestions(@RequestParam String searchText, @RequestParam String questType, @RequestParam String category) {
        List<Question> questions = questionService.getAllQuestByTypeIsAndCategoryIsAndTitleContaining(questType, category, searchText);
        return new ResponseEntity<>(questions, HttpStatus.ACCEPTED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Optional<Question> optionalQuestion = questionService.findById(id);
        return optionalQuestion.map(question -> new ResponseEntity<>(question, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/quest-list/{id}")
    public ResponseEntity<List<Question>> getAllQuestionListByExamId(@PathVariable Long id) {
        List<Question> allQuestionByExamId = questionService.getAllQuestionByExamId(id);
        return new ResponseEntity<>(allQuestionByExamId, HttpStatus.ACCEPTED);
    }
}
