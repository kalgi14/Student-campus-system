package edu.depaul.cdm.se452.concept.controller.services.interfaces;

import edu.depaul.cdm.se452.concept.model.Enrollment;

import java.util.List;

public interface IEnrollmentService {
    public List<Enrollment> findAll();

    public Enrollment update(Enrollment ce);

    public Enrollment findById(int id);

    public void deleteById(int id);
}
