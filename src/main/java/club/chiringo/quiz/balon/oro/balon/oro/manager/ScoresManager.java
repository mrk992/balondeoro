package club.chiringo.quiz.balon.oro.balon.oro.manager;

import club.chiringo.quiz.balon.oro.balon.oro.model.ScoreType;
import club.chiringo.quiz.balon.oro.balon.oro.model.Scores;
import club.chiringo.quiz.balon.oro.balon.oro.model.VoteJSON;
import club.chiringo.quiz.balon.oro.balon.oro.model.repository.IFiesteroRepository;
import club.chiringo.quiz.balon.oro.balon.oro.model.repository.IScoresRepository;
import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScoresManager {

    @Autowired
    IScoresRepository scoresRepository;

    @Autowired
    IFiesteroRepository fiesteroRepository;

    public void updateScores(VoteJSON voteJSON) {

        voteJSON.getScores().forEach(
                score -> score.getAwards().forEach(
                        awards -> updateScoreByFiestero(awards.getFiesteroId(), awards.getStars(), score.getType())
                )
        );

    }

    private void updateScoreByFiestero(String fiesteroId, int stars, ScoreType type) {

        Scores scores = scoresRepository.findByFiesteroId(fiesteroId).orElseGet(()->createScore(fiesteroId));
        switch (type) {
            case drunk:
                scores.setDrunkVotes(scores.getDrunkVotes() + 1);
                scores.setDrunkScore(scores.getDrunkScore() + stars);
                break;
            case married:
                scores.setMarriedVotes(scores.getMarriedVotes() + 1);
                scores.setMarriedScore(scores.getMarriedScore() + stars);
                break;
            case constant:
                scores.setConstVotes(scores.getConstVotes() + 1);
                scores.setConstScore(scores.getConstScore() + stars);
                break;
        }
        scoresRepository.save(scores);
    }

    private Scores createScore(String fiesteroId){

        Scores scores = new Scores();
        scores.setFiesteroId(fiesteroId);
        scores.setDrunkScore(0);
        scores.setDrunkVotes(0);
        scores.setMarriedScore(0);
        scores.setMarriedVotes(0);
        scores.setConstScore(0);
        scores.setConstVotes(0);
        return scores;
    }


}
