package edu.depaul.cdm.se452.concept.controller.services.implimentation;

import edu.depaul.cdm.se452.concept.model.CourseEntity;
import edu.depaul.cdm.se452.concept.controller.database.mysql.repository.CourseRepository;
import edu.depaul.cdm.se452.concept.controller.services.interfaces.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

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
    public CourseEntity findById(String id) {
        return repo.findById(UUID.fromString(id)).get();
    }
}
