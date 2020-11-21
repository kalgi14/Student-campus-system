package edu.depaul.cdm.se452.concept.controller.database.mysql.repository;

import edu.depaul.cdm.se452.concept.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID>{
    List<StudentEntity> findById(String id);
}
