package club.chiringo.quiz.balon.oro.balon.oro.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Fiestero {
    @Id
    public ObjectId _id;
    private String name;
    private int score;
    private String photoURL;
    private String videoURL;
}
