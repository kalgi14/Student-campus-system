package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.CourseCatalogEntity;
import edu.depaul.cdm.se452.concept.database.mysql.repository.CourseCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class CourseCatalogService implements ICourseCatalogService {
    @Autowired
    EntityManagerFactory emf;

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
    public CourseCatalogEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(int id) {repository.deleteById(id);
    }

    public List CCS() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery(
                "SELECT a.CLASS_ID, c.courseID, c.shortName, c.name, d.FIRST_NAME, d.LAST_NAME " +
                        "FROM CourseCatalogEntity a " +
                        "join CourseEntity c on a.COURSE_ID=c.courseID "+
                        "join ProfessorEntity d on a.PROFESSOR_ID=d.PROFESSOR_ID");
        return query.getResultList();
    }
}


