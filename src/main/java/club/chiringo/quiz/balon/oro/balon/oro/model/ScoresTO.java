package club.chiringo.quiz.balon.oro.balon.oro.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ScoresTO implements Serializable {
    List<StarsTO> awards;
    private ScoreType type;

    /*private int fiveStars;
    private int threeStars;
    private int oneStars;*/
}
