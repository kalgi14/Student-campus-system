package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.adminEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IAdminService {

    public List<adminEntity> findAll();

    public adminEntity update(adminEntity grade);

    public adminEntity findById(int id);

}
