package club.chiringo.quiz.balon.oro.balon.oro.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/scores")
    public String scores() {

        return "scores";
    }

}
