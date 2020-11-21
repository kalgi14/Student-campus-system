package edu.depaul.cdm.se452.concept.controller.database.mysql.repository;

import edu.depaul.cdm.se452.concept.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

}
