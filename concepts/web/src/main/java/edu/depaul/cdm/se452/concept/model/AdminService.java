package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.adminEntity;
import edu.depaul.cdm.se452.concept.database.mysql.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@ConditionalOnProperty(name = "datasource", havingValue = "db")
@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminRepository repo;

    @Override
    public List<adminEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public adminEntity update(adminEntity course) {
        repo.save(course);
        return course;
    }

    @Override
    public adminEntity findById(int id) {
        return repo.findById(id);
    }
}
