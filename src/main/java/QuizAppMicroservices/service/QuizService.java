package QuizAppMicroservices.service;

import QuizAppMicroservices.model.QuestionModel;
import QuizAppMicroservices.model.QuizModel;
import QuizAppMicroservices.repo.QuestionDAO;
import QuizAppMicroservices.repo.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<String> getQuizQuestions(String category, int numOfQuestions, String title) {
//        quizDao.getQuizQuestions(category,numOfQuestions);
        List<QuestionModel> quetions = questionDAO.getRandomQuestions(numOfQuestions,category);
        QuizModel quizModel = new QuizModel();
        quizModel.setQuestionTitle(title);
        quizModel.setQuestions(quetions);
        quizDao.save(quizModel);
        return new ResponseEntity<>("Success is not good Always", HttpStatus.OK);
    }
}
