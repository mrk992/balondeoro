package club.chiringo.quiz.balon.oro.balon.oro.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "Scores")
public class Scores {

    @Id
    @Field("fiesteroId")
    private String fiesteroId;

    @Field("drunkScore")
    private int drunkScore;

    @Field("drunkVotes")
    private int drunkVotes;

    @Field("marriedScore")
    private int marriedScore;

    @Field("marriedVotes")
    private int marriedVotes;

    @Field("constScore")
    private int constScore;

    @Field("constVotes")
    private int constVotes;
}
