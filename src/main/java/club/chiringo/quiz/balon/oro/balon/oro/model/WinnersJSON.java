package club.chiringo.quiz.balon.oro.balon.oro.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class WinnersJSON implements Serializable {
    private Fiestero winner;
    private Fiestero married;
    private Fiestero constant;
    private Fiestero drunk;
}
