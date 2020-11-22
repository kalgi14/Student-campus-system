package edu.depaul.cdm.se452.concept.model;


import edu.depaul.cdm.se452.concept.database.mysql.domain.Enrollment;
import edu.depaul.cdm.se452.concept.database.mysql.repository.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@ConditionalOnProperty(name = "datasource", havingValue = "db")
@Service
public class enrollmentService implements IEnrollmentService {

    @Autowired
    private EnrollmentRepo repository;

    @Override
    public List<Enrollment> findAll() {
        return repository.findAll();
    }

    @Override
    public Enrollment update(Enrollment enrol) {
        repository.save(enrol);
        return enrol;
    }

    @Override
    public Enrollment findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}