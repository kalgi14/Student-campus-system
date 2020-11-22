package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.ProfessorEntity;
import edu.depaul.cdm.se452.concept.database.mysql.repository.ProfessorRepository;
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
    public ProfessorEntity findById(int id) {
        return repo.findById(id);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
