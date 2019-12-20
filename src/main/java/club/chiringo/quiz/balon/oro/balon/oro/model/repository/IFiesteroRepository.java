package club.chiringo.quiz.balon.oro.balon.oro.model.repository;

import club.chiringo.quiz.balon.oro.balon.oro.model.Fiestero;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFiesteroRepository extends MongoRepository<Fiestero, String> {

    Fiestero findBy_id(ObjectId id);

}
