package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.Enrollment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.*;

import java.util.List;

@Component
public interface IEnrollmentService {
    public List<Enrollment> findAll();

    public Enrollment update(Enrollment ce);

    public Enrollment findById(int id);

    public void deleteById(int id);
}
