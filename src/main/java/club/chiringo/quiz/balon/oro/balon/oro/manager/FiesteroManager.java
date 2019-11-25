package club.chiringo.quiz.balon.oro.balon.oro.manager;

import club.chiringo.quiz.balon.oro.balon.oro.model.Fiestero;
import club.chiringo.quiz.balon.oro.balon.oro.model.FiesteroTO;
import club.chiringo.quiz.balon.oro.balon.oro.model.repository.IFiesteroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FiesteroManager {

    @Autowired
    private IFiesteroRepository fiesteroRepository;

    public List<Fiestero> getAllFiesteros(){
        return fiesteroRepository.findAll();
    }

    public void addAwardsToFiesteros(List<FiesteroTO> fiesteros){
        fiesteros.forEach(fiestero -> {
            Fiestero updateFiestero = fiesteroRepository.findBy_id(fiestero.getObjectId());
            updateFiestero.setScore(updateFiestero.getScore() + fiestero.getAward().getValue());
            fiesteroRepository.save(updateFiestero);
        });
    }
}
