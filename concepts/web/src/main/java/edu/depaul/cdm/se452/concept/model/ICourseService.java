package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.CourseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ICourseService {

    public List<CourseEntity> findAll();

    public CourseEntity update(CourseEntity grade);

    public CourseEntity findById(int id);

}
