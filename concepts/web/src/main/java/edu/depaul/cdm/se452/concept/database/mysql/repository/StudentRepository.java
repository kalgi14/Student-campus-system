package edu.depaul.cdm.se452.concept.database.mysql.repository;

import edu.depaul.cdm.se452.concept.database.mysql.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
    StudentEntity findById(int id);
}
