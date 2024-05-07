package QuizAppMicroservices.service;

import QuizAppMicroservices.model.QuizModel;
import QuizAppMicroservices.repo.QuizDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Component

public class QuizService {
    @Autowired
    QuizDAO quizDAO;

    public ResponseEntity<List<QuizModel>> getAllQuestion() {
        try {
            return new ResponseEntity<>(quizDAO.findAll(), HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestions(QuizModel questions) {
        try{
            quizDAO.save(questions);
            return new ResponseEntity<>("added",HttpStatus.OK);
        }
       catch (Exception e){
            e.printStackTrace();
       }

        return new ResponseEntity<>("Not Added",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuizModel>> findByCategory(String categoryType) {
        try{
            return new ResponseEntity<>(quizDAO.findByCategory(categoryType),HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);


    }
}
