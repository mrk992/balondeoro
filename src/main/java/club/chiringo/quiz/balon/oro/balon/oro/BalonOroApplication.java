package club.chiringo.quiz.balon.oro.balon.oro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)
public class BalonOroApplication {

    public static void main(String[] args) {
        SpringApplication.run(BalonOroApplication.class, args);
    }

}
