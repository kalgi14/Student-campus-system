package edu.depaul.cdm.se452.concept.database.mysql.repository;

import edu.depaul.cdm.se452.concept.database.mysql.domain.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    CourseEntity findById(int id);
}
