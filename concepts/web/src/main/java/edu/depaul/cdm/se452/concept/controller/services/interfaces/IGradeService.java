package edu.depaul.cdm.se452.concept.controller.services.interfaces;

import edu.depaul.cdm.se452.concept.model.GradeEntity;
import edu.depaul.cdm.se452.concept.model.GradeKey;

import java.util.List;

public interface IGradeService {

    public List<GradeEntity> findAll();

    public GradeEntity update(GradeEntity grade);

    public GradeEntity findById(GradeKey id);

    public List <GradeEntity> findByStudent(String studentID);

    public List <GradeEntity> findByClass(String classID);

}
