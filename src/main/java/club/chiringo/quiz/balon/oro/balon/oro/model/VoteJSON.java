package club.chiringo.quiz.balon.oro.balon.oro.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class VoteJSON implements Serializable {
    private int fiesteroId;
    private List<ScoresTO> scores;
}
