package edu.depaul.cdm.se452.concept.controller.services.implimentation;

import edu.depaul.cdm.se452.concept.model.ProfessorEntity;
import edu.depaul.cdm.se452.concept.controller.database.mysql.repository.ProfessorRepository;
import edu.depaul.cdm.se452.concept.controller.services.interfaces.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class ProfessorService implements IProfessorService {

    @Autowired
    private ProfessorRepository repo;


    @Override
    public List<ProfessorEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public ProfessorEntity update(ProfessorEntity professor) {
        repo.save(professor);
        return professor;
    }

    @Override
    public ProfessorEntity findById(String id) {
        return repo.findById(UUID.fromString(id)).get();
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(UUID.fromString(id));
    }
}
