package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.GradesEntity;

import java.util.List;

public interface IGradesService {
    public List<GradesEntity> findAll();

    public GradesEntity update(GradesEntity ce);

    public GradesEntity findById(int id);

    public void deleteById(int id);
}
