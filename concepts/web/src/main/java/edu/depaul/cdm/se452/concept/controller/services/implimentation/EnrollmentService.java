package edu.depaul.cdm.se452.concept.controller.services.implimentation;

import edu.depaul.cdm.se452.concept.controller.database.mysql.repository.EnrollmentRepository;
import edu.depaul.cdm.se452.concept.controller.services.interfaces.IEnrollmentService;
import edu.depaul.cdm.se452.concept.model.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@ConditionalOnProperty(name = "datasource", havingValue = "db")
@Service
public class EnrollmentService implements IEnrollmentService {

    @Autowired
    private EnrollmentRepository repository;

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
