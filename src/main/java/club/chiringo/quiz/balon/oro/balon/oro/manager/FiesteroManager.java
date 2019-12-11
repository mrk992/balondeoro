package club.chiringo.quiz.balon.oro.balon.oro.manager;

import club.chiringo.quiz.balon.oro.balon.oro.model.Fiestero;
import club.chiringo.quiz.balon.oro.balon.oro.model.FiesteroTO;
import club.chiringo.quiz.balon.oro.balon.oro.model.Scores;
import club.chiringo.quiz.balon.oro.balon.oro.model.repository.IFiesteroRepository;
import club.chiringo.quiz.balon.oro.balon.oro.model.repository.IScoresRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiesteroManager {

    @Autowired
    private IFiesteroRepository fiesteroRepository;

    @Autowired
    private IScoresRepository scoresRepository;

    public List<FiesteroTO> getAllFiesterosTO() {
        return fiesteroRepository.findAll().stream().map(
                fiestero -> {
                    FiesteroTO fiesteroTO = new FiesteroTO();
                    fiesteroTO.setId(fiestero.get_id().toString());
                    fiesteroTO.setName(fiestero.getName());
                    return fiesteroTO;
                }
        ).collect(Collectors.toList());
    }

    public List<Fiestero> getAllFiesteros() {
        return fiesteroRepository.findAll();
    }

    public void saveFiesteros(List<Fiestero> fiesteros) {
        fiesteroRepository.saveAll(fiesteros);
    }


    public void updateFiesterosScores() {
        List<Fiestero> fiesteros = fiesteroRepository.findAll();
        fiesteros.forEach(
                fiestero -> {
                    Scores scores = scoresRepository.findByFiesteroId(fiestero.get_id().toString()).orElse(null);
                    fiestero.setMainScore(5 * scores.getDrunkScore() + 3 * scores.getConstScore() - 2 * scores.getMarriedScore());

                    if(scores.getConstScore() != 0) {
                        fiestero.setMainConstantScore(scores.getConstScore() / scores.getConstVotes());
                    }
                    if(scores.getDrunkScore() != 0) {
                        fiestero.setMainDrunkScore(scores.getDrunkScore() / scores.getDrunkVotes());
                    }
                    if(scores.getMarriedScore() != 0) {
                        fiestero.setMainMarriedScore(scores.getMarriedScore() / scores.getMarriedVotes());
                    }
                }
        );
        fiesteroRepository.saveAll(fiesteros);
    }
}
