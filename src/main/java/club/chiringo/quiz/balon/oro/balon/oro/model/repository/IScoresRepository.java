package club.chiringo.quiz.balon.oro.balon.oro.model.repository;

import club.chiringo.quiz.balon.oro.balon.oro.model.Scores;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IScoresRepository extends MongoRepository<Scores, String> {

    Optional<Scores> findByFiesteroId(String fiesteroId);
}
