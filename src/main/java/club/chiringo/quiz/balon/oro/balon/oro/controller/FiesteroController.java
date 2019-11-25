package club.chiringo.quiz.balon.oro.balon.oro.controller;

import club.chiringo.quiz.balon.oro.balon.oro.manager.FiesteroManager;
import club.chiringo.quiz.balon.oro.balon.oro.model.Fiestero;
import club.chiringo.quiz.balon.oro.balon.oro.model.FiesteroTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz/fiestero")
public class FiesteroController {

    @Autowired
    private FiesteroManager fiesteroManager;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listFiesteros() {
        return new ResponseEntity<>(fiesteroManager.getAllFiesteros(), HttpStatus.OK);
    }

    @PostMapping(value = "/vote", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity AddVote(@RequestBody List<FiesteroTO> fiesterosList) {
        fiesteroManager.addAwardsToFiesteros(fiesterosList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
