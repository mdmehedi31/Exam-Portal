package com.exam.controller;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.service.definition.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getQuiz/{qid}")
    public Quiz getQuiz(@PathVariable("qid") Long qid){

        return this.quizService.getQuiz(qid);
    }

    // Delete a single Quiz
    @DeleteMapping("/delete/{qId}")
    public void delete(@PathVariable("qId") Long qId){
        this.quizService.deleteQuiz(qId);
    }


    @GetMapping("/category/{catId}")
    public List<Quiz> getQuizOfCategory(@PathVariable("catId") Long catId){

        Category category= new Category();
        category.setCatId(catId);

        return this.quizService.getQuizOfCategory(category);
    }

    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes(){
        return this.quizService.getActiveQuizzes();
    }

    @GetMapping("/active/category/{catId}")
    public List<Quiz> getActiveCategoryQuizzes(@PathVariable("catId")Long catId){

        Category category= new Category();
        category.setCatId(catId);
      return this.quizService.getActiveQuizzesOfCategory(category);

    }
}
