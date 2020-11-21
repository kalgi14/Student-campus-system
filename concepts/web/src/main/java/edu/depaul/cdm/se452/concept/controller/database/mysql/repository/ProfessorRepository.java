package edu.depaul.cdm.se452.concept.controller.database.mysql.repository;

import edu.depaul.cdm.se452.concept.model.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, UUID> {
}
