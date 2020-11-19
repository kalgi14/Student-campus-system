package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.GradesEntity;
import edu.depaul.cdm.se452.concept.database.mysql.repository.GradesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class GradesService implements IGradesService {

    @Autowired
    private GradesRepository repository;

    @Override
    public List<GradesEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public GradesEntity update(GradesEntity student) {
        repository.save(student);
        return student;
    }

    @Override
    public GradesEntity findById(String id) {
        return repository.findById(UUID.fromString(id)).get();
    }

    @Override
    public void deleteById(String id) {repository.deleteById(UUID.fromString(id));
    }
}
