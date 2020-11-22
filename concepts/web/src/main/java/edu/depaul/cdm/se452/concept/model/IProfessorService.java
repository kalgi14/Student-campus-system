package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.ProfessorEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IProfessorService {
    public List<ProfessorEntity> findAll();

    public ProfessorEntity update(ProfessorEntity professor);

    public ProfessorEntity findById(int id);

    public void deleteById(int id);

}
