package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.model.question.Answer;
import com.case6.quizchallengeweb.model.question.Category;
import com.case6.quizchallengeweb.model.question.UserAnswer;
import com.case6.quizchallengeweb.model.user.AppUser;
import com.case6.quizchallengeweb.service.question.answer.IAnswerService;
import com.case6.quizchallengeweb.service.question.useranswer.IUserAnswerService;
import com.case6.quizchallengeweb.service.user.appuser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/answers")
public class AnswerController {
    @Autowired
    private IAnswerService answerService;

    @Autowired
    private IAppUserService userService;
    @Autowired
    private IUserAnswerService userAnswerService;

    @GetMapping
    public ResponseEntity<Iterable<Answer>> findAllAnswer(){
        return new ResponseEntity<>(answerService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer){
        try {
            answerService.save(answer);
            return new ResponseEntity<>(answer, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @DeleteMapping("/{id}")
//    public  ResponseEntity<Answer>deleteAnswer(@PathVariable Long id){
//        try {
//            Answer answer = answerService.findById(id).get();
//            answerService.delete(id);
//            return new ResponseEntity<>(answer, HttpStatus.OK);
//        }catch (Exception exception){
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, "Provide correct Actor Id", exception);
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Answer> deleteAnswer(@PathVariable Long id) {
        Optional<Answer> answerOptional = answerService.findById(id);
        return answerOptional.map(answer -> {
            answerService.delete(id);
            return new ResponseEntity<Answer>(HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/current-user/{userid}/{examid}")
    public ResponseEntity<List<UserAnswer>> getAllCurrentUserAnswer(@PathVariable Long userid, @PathVariable Long examid) {
        AppUser fakeCurrentUser = this.userService.findById(userid).get();
        List<UserAnswer> allUserAnswer = userAnswerService.getAllUserAnswer(fakeCurrentUser, examid);
        return new ResponseEntity<>(allUserAnswer, HttpStatus.ACCEPTED);

    }
}
