package edu.depaul.cdm.se452.concept.database.mysql.repository;

import edu.depaul.cdm.se452.concept.database.mysql.domain.CategoryEntity;
import edu.depaul.cdm.se452.concept.database.mysql.domain.GradeEntity;
import edu.depaul.cdm.se452.concept.model.GradeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, UUID> {
    List<Object> findById(GradeKey id);
}
