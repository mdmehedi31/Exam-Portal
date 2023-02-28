package com.exam.controller;

import com.exam.model.exam.Quiz;
import com.exam.service.definition.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {


    @Autowired
    private QuizService quizService;


    // Add Quiz
    @PostMapping("/add")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    // Update Quiz
    @PutMapping("/update")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){

        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    // get Quiz List
   @GetMapping("/quizList")
   public ResponseEntity<?> quizList(){
        return ResponseEntity.ok(this.quizService.getQuizList());
    }


    // get a single quiz
    @GetMapping("/quiz/{qid}")
    public Quiz getQuiz(@PathVariable("qid") Long qid){

        return this.quizService.getQuiz(qid);
    }

    // Delete a single Quiz
    @DeleteMapping("/delete/{qid}")
    public void delete(@PathVariable("qid") Long qid){
        this.quizService.deleteQuiz(qid);
    }
}
