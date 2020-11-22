package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.StudentEntity;
import java.util.List;

public interface IStudentService {
    public List<StudentEntity> findAll();

    public StudentEntity update(StudentEntity ce);

    public StudentEntity findById(int id);

    public void deleteById(int id);
}
