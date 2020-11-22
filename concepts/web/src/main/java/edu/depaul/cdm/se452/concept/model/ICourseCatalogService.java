package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.CourseCatalogEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ICourseCatalogService {
    public List<CourseCatalogEntity> findAll();

    public CourseCatalogEntity update(CourseCatalogEntity ce);

    public CourseCatalogEntity findById(int id);

    public void deleteById(int id);
}

