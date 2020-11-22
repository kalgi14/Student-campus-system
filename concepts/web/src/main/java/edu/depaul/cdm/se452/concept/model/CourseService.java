package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.CourseEntity;
import edu.depaul.cdm.se452.concept.database.mysql.repository.CourseRepository;
import edu.depaul.cdm.se452.concept.model.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@ConditionalOnProperty(name = "datasource", havingValue = "db")
@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository repo;

    @Override
    public List<CourseEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public CourseEntity update(CourseEntity course) {
        repo.save(course);
        return course;
    }

    @Override
    public CourseEntity findById(int id) {
        return repo.findById(id);
    }
}
