package edu.depaul.cdm.se452.concept.controller.services.interfaces;

import edu.depaul.cdm.se452.concept.model.TuitionEntity;

import java.util.List;

public interface ITuitionService {
    public List<TuitionEntity> findAll();

    public TuitionEntity update(TuitionEntity ce);

    public TuitionEntity findById(String id);

    public void deleteById(String id);
}