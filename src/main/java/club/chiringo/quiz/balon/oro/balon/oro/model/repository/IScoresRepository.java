package club.chiringo.quiz.balon.oro.balon.oro.model.repository;

import club.chiringo.quiz.balon.oro.balon.oro.model.Scores;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScoresRepository extends MongoRepository<Scores, String> {

    Scores findByFiesteroId(ObjectId fiesteroId);
}
