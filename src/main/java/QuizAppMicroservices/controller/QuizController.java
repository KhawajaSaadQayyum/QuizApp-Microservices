package QuizAppMicroservices.controller;

import QuizAppMicroservices.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @GetMapping("create")
    public ResponseEntity<String> createNewQuiz(@RequestParam String category, @RequestParam int numOfQuestions, @RequestParam String title){
         return quizService.getQuizQuestions(category,numOfQuestions, title);
        //        return new ResponseEntity<>("Hello Dear ", HttpStatus.OK);
    }
}
