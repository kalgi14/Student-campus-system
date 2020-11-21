package edu.depaul.cdm.se452.concept.controller.services.interfaces;

import edu.depaul.cdm.se452.concept.model.Enrollment;
import edu.depaul.cdm.se452.concept.model.ProfessorEntity;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IProfessorService {
    public List<ProfessorEntity> findAll();

    public ProfessorEntity update(ProfessorEntity professor);

    public ProfessorEntity findById(String id);

    public void deleteById(String id);

}
