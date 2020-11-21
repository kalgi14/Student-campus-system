package edu.depaul.cdm.se452.concept.controller.database.mysql.repository;

import edu.depaul.cdm.se452.concept.model.CourseCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseCatalogRepository extends JpaRepository<CourseCatalogEntity, UUID> {
    List<CourseCatalogEntity> findById(String id);

}


