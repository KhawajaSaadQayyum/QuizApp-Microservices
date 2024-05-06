package QuizAppMicroservices.repo;

import QuizAppMicroservices.model.QuizModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizDAO extends JpaRepository<QuizModel, Integer> {
//    Optional<QuizModel> findByCategory(String category);
}
