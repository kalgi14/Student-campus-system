package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.CourseCatalogEntity;
import edu.depaul.cdm.se452.concept.database.mysql.repository.CourseCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class CourseCatalogService implements ICourseCatalogService {

    @Autowired
    private CourseCatalogRepository repository;

    @Override
    public List<CourseCatalogEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public CourseCatalogEntity update(CourseCatalogEntity student) {
        repository.save(student);
        return student;
    }

    @Override
    public CourseCatalogEntity findById(String id) {
        return repository.findById(UUID.fromString(id)).get();
    }

    @Override
    public void deleteById(String id) {repository.deleteById(UUID.fromString(id));
    }
}


