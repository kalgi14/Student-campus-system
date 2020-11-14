package edu.depaul.cdm.se452.concept.services.interfaces;

import edu.depaul.cdm.se452.concept.database.mysql.domain.StudentEntity;
import java.util.List;

public interface IStudentService {
    public List<StudentEntity> findAll();

    public StudentEntity update(StudentEntity ce);

    public StudentEntity findById(String id);

    public void deleteById(String id);
}
