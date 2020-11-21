package edu.depaul.cdm.se452.concept.controller.database.mysql.repository;

import edu.depaul.cdm.se452.concept.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    Enrollment findById(int id);

//    void update(Enrollment enroll);
}