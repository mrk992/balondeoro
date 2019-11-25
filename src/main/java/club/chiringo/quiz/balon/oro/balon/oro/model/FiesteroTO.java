package club.chiringo.quiz.balon.oro.balon.oro.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.io.Serializable;

@Getter
@Setter
public class FiesteroTO implements Serializable {
    private ObjectId objectId;
    private AwardType award;
}
