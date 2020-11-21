package edu.depaul.cdm.se452.concept.controller.services.interfaces;

import edu.depaul.cdm.se452.concept.model.StudentEntity;
import java.util.List;

public interface IStudentService {
    public List<StudentEntity> findAll();

    public StudentEntity update(StudentEntity ce);

    public StudentEntity findById(String id);

    public StudentEntity findById(int id);

    public void deleteById(String id);
}
