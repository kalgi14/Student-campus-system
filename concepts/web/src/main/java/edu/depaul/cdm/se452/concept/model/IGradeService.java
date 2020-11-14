package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.CategoryEntity;
import edu.depaul.cdm.se452.concept.database.mysql.domain.GradeEntity;
import edu.depaul.cdm.se452.concept.database.mysql.domain.TuitionEntity;

import java.util.List;

public interface IGradeService {

    public List<GradeEntity> findAll();

    public GradeEntity update(GradeEntity grade);

    public GradeEntity findById(GradeKey id);

}
