package club.chiringo.quiz.balon.oro.balon.oro.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "Fiestero")
public class Fiestero {
    @Id
    @Field("_id")
    public ObjectId _id;

    @Field("name")
    private String name;

    @Field("mainScore")
    private int mainScore;

    @Field("mainDrunkScore")
    private int mainDrunkScore;

    @Field("mainMarriedScore")
    private int mainMarriedScore;

    @Field("mainConstantScore")
    private int mainConstantScore;

    @Field("photoURL")
    private String photoURL;

    @Field("videoURL")
    private String videoURL;
}
