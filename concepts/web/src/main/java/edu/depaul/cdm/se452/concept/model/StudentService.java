package edu.depaul.cdm.se452.concept.model;

import java.util.List;
import java.util.UUID;
import edu.depaul.cdm.se452.concept.database.mysql.domain.StudentEntity;
import edu.depaul.cdm.se452.concept.database.mysql.repository.StudentRepository;
import edu.depaul.cdm.se452.concept.model.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository repo;

    @Override
    public List<StudentEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public StudentEntity update(StudentEntity student) {
        repo.save(student);
        return student;
    }

    @Override
    public StudentEntity findById(int id) {
        return repo.findById(id);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
