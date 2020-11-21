package edu.depaul.cdm.se452.concept.controller.services.interfaces;

import edu.depaul.cdm.se452.concept.model.CategoryEntity;
import java.util.List;

public interface ICategoryService {
    public List<CategoryEntity> findAll();

    public CategoryEntity update(CategoryEntity ce);

    public CategoryEntity findById(String id);

    public void deleteById(String id);
}
