package QuizAppMicroservices.controller;

import QuizAppMicroservices.model.QuestionModel;
import QuizAppMicroservices.repo.QuestionDAO;
import QuizAppMicroservices.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService quizService;
    QuestionDAO quizDAO;
  @GetMapping("/getAll")
    public ResponseEntity<List<QuestionModel>> getQuizQuestions(){
        return quizService.getAllQuestion();
    }

@PostMapping("/add")
public ResponseEntity<String> addNewQuestion(@RequestBody QuestionModel questions) {
    quizService.addQuestion(questions);
     return new ResponseEntity<>("success", HttpStatus.OK);

}
@GetMapping("/getBy/{category}")
    public ResponseEntity<List<QuestionModel>> findByCategory(@PathVariable String category){
      return quizService.findByCategory(category);
}
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
      return quizService.delete(id);
   }
}
