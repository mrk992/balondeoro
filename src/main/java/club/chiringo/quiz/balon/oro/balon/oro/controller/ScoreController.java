package club.chiringo.quiz.balon.oro.balon.oro.controller;

import club.chiringo.quiz.balon.oro.balon.oro.manager.ScoresManager;
import club.chiringo.quiz.balon.oro.balon.oro.model.VoteJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz/score")
public class ScoreController {

    @Autowired
    private ScoresManager scoresManager;

    @PostMapping(value = "/vote", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addVote(@RequestBody VoteJSON vote) {
        scoresManager.updateScores(vote);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}