package edu.depaul.cdm.se452.concept.services.interfaces;

import edu.depaul.cdm.se452.concept.database.mysql.domain.ProfessorEntity;
import java.util.List;

public interface IProfessorService {
    public List<ProfessorEntity> findAll();

    public ProfessorEntity update(ProfessorEntity professor);

    public ProfessorEntity findById(String id);

    public void deleteById(String id);
}
