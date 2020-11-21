package edu.depaul.cdm.se452.concept.controller.services.interfaces;

import edu.depaul.cdm.se452.concept.model.CourseEntity;

import java.util.List;

public interface ICourseService {

    public List<CourseEntity> findAll();

    public CourseEntity update(CourseEntity grade);

    public CourseEntity findById(String id);

}
