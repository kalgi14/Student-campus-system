package edu.depaul.cdm.se452.concept.controller.database.mysql.repository;

import edu.depaul.cdm.se452.concept.model.GradesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GradesRepository extends JpaRepository<GradesEntity, UUID> {
    List<GradesEntity> findById(String id);

}
