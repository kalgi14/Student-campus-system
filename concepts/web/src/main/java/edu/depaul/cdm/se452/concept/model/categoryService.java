package edu.depaul.cdm.se452.concept.model;

import java.util.List;
import java.util.UUID;

import edu.depaul.cdm.se452.concept.database.mysql.domain.CategoryEntity;
import edu.depaul.cdm.se452.concept.database.mysql.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class categoryService implements ICategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<CategoryEntity> findAll() {

        return repository.findAll();
    }

    @Override
    public CategoryEntity update(CategoryEntity student) {
        repository.save(student);
        return student;
    }

    @Override
    public CategoryEntity findById(String id) {

        return repository.findById(UUID.fromString(id)).get();
    }

    @Override
    public void deleteById(String id) {

        repository.deleteById(UUID.fromString(id));
    }
}
