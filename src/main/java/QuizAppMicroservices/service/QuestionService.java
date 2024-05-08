package QuizAppMicroservices.service;

import QuizAppMicroservices.model.QuestionModel;
import QuizAppMicroservices.repo.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component

public class QuestionService {
    @Autowired
    QuestionDAO quizDAO;

    public ResponseEntity<List<QuestionModel>> getAllQuestion() {
        try {
            return new ResponseEntity<>(quizDAO.findAll(), HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(QuestionModel question) {
        try{
            quizDAO.save(question);
            return new ResponseEntity<>("added",HttpStatus.OK);
        }
       catch (Exception e){
            e.printStackTrace();
       }

        return new ResponseEntity<>("Not Added",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionModel>> findByCategory(String categoryType) {
        try{
            return new ResponseEntity<>(quizDAO.findByCategory(categoryType),HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<String> delete(int id) {
        quizDAO.deleteById(id);
        try{
            return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        }
       catch (Exception e){
            e.printStackTrace();
       }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }
}
