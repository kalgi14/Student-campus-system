package edu.depaul.cdm.se452.concept.controller.services.implimentation;

import edu.depaul.cdm.se452.concept.model.TuitionEntity;
import edu.depaul.cdm.se452.concept.controller.database.mysql.repository.TuitionRepository;
import edu.depaul.cdm.se452.concept.controller.services.interfaces.ITuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class TuitionService implements ITuitionService {

    @Autowired
    private TuitionRepository repository;

    @Override
    public List<TuitionEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public TuitionEntity update(TuitionEntity student) {
        repository.save(student);
        return student;
    }

    @Override
    public TuitionEntity findById(String id) {
        return repository.findById(UUID.fromString(id)).get();
    }

    @Override
    public void deleteById(String id) {repository.deleteById(UUID.fromString(id));
    }
}