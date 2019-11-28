package club.chiringo.quiz.balon.oro.balon.oro.manager;

import club.chiringo.quiz.balon.oro.balon.oro.model.Fiestero;
import club.chiringo.quiz.balon.oro.balon.oro.model.Scores;
import club.chiringo.quiz.balon.oro.balon.oro.model.repository.IFiesteroRepository;
import club.chiringo.quiz.balon.oro.balon.oro.model.repository.IScoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiesteroManager {

    @Autowired
    private IFiesteroRepository fiesteroRepository;

    @Autowired
    private IScoresRepository scoresRepository;

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
                    Scores scores = scoresRepository.findByFiesteroId(fiestero._id);
                    fiestero.setMainScore(5 * scores.getDrunkScore() + 3 * scores.getConstScore() - 2 * scores.getMarriedScore());
                    fiestero.setMainConstantScore(scores.getConstScore() / scores.getConstVotes());
                    fiestero.setMainDrunkScore(scores.getDrunkScore() / scores.getDrunkVotes());
                    fiestero.setMainMarriedScore(scores.getMarriedScore() / scores.getMarriedVotes());
                }
        );
        fiesteroRepository.saveAll(fiesteros);
    }
}
