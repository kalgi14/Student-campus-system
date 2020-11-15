package edu.depaul.cdm.se452.concept.services.interfaces;

import edu.depaul.cdm.se452.concept.database.mysql.domain.CourseEntity;

import java.util.List;
import java.util.UUID;

public interface ICourseService {

    public List<CourseEntity> findAll();

    public CourseEntity update(CourseEntity grade);

    public CourseEntity findById(String id);

}
