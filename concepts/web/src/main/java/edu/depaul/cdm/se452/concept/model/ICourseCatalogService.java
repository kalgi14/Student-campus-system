package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.CourseCatalogEntity;

import java.util.List;

public interface ICourseCatalogService {
    public List<CourseCatalogEntity> findAll();

    public CourseCatalogEntity update(CourseCatalogEntity ce);

    public CourseCatalogEntity findById(String id);

    public void deleteById(String id);
}

