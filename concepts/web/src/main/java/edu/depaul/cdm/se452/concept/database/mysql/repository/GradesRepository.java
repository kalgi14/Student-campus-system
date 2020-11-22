package edu.depaul.cdm.se452.concept.database.mysql.repository;

import edu.depaul.cdm.se452.concept.database.mysql.domain.GradesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GradesRepository extends JpaRepository<GradesEntity, Integer> {
    GradesEntity findById(int id);

}
