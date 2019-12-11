package club.chiringo.quiz.balon.oro.balon.oro.controller;

import club.chiringo.quiz.balon.oro.balon.oro.manager.FiesteroManager;
import club.chiringo.quiz.balon.oro.balon.oro.model.Fiestero;
import club.chiringo.quiz.balon.oro.balon.oro.model.WinnersJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/quiz/fiestero")
public class FiesteroController {

    @Autowired
    private FiesteroManager fiesteroManager;


    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listFiesteros() {
        return new ResponseEntity<>(fiesteroManager.getAllFiesterosTO(), HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveFiesteros(@RequestBody List<Fiestero> fiesteros) {
        fiesteroManager.saveFiesteros(fiesteros);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/winners", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity retrieveWinner() {

        fiesteroManager.updateFiesterosScores();
        WinnersJSON winners = new WinnersJSON();
        List<Fiestero> fiesteros = fiesteroManager.getAllFiesteros();

        winners.setWinner(fiesteros.stream().sorted(Comparator.comparing(Fiestero::getMainScore).reversed()).collect(Collectors.toList()).get(0));
        fiesteros.remove(winners.getWinner());

        winners.setDrunk(fiesteros.stream().sorted(Comparator.comparing(Fiestero::getMainDrunkScore).reversed()).collect(Collectors.toList()).get(0));
        fiesteros.remove(winners.getDrunk());

        winners.setConstant(fiesteros.stream().sorted(Comparator.comparing(Fiestero::getMainConstantScore).reversed()).collect(Collectors.toList()).get(0));
        fiesteros.remove(winners.getConstant());

        winners.setMarried(fiesteros.stream().sorted(Comparator.comparing(Fiestero::getMainMarriedScore).reversed()).collect(Collectors.toList()).get(0));

        return new ResponseEntity<>(winners, HttpStatus.OK);
    }
}
