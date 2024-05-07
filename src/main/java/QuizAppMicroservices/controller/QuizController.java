package QuizAppMicroservices.controller;

import QuizAppMicroservices.model.QuizModel;
import QuizAppMicroservices.repo.QuizDAO;
import QuizAppMicroservices.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuizController {
    @Autowired
    QuizService quizService;
    QuizDAO quizDAO;
  @GetMapping("/get")
    public ResponseEntity<List<QuizModel>> getQuizQuestions(){
        return quizService.getAllQuestion();
    }

@PostMapping("/add")
public ResponseEntity<String> createEmployee(@RequestBody QuizModel questions) {
    quizService.addQuestions(questions);
     return new ResponseEntity<>("success", HttpStatus.OK);

}
@GetMapping("/getBy/{category}")
    public ResponseEntity<List<QuizModel>> findByCategory(@PathVariable String category){
      return quizService.findByCategory(category);
}
}
