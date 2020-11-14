package edu.depaul.cdm.se452.concept.services.implimentation;

import edu.depaul.cdm.se452.concept.database.mysql.domain.GradeEntity;
import edu.depaul.cdm.se452.concept.database.mysql.repository.GradeRepository;
import edu.depaul.cdm.se452.concept.services.interfaces.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class GradeService implements IGradeService {

    @Autowired
    private GradeRepository repository;

    @Override
    public List<GradeEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public GradeEntity update(GradeEntity grade) {
        repository.save(grade);
        return grade;
    }

    //TODO: This won't work as is need help to configure.
    @Override
    public GradeEntity findById(GradeKey id) {
        return repository.findById(UUID.fromString(id.toString())).get();
    }

}
