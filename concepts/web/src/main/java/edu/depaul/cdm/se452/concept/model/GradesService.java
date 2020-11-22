package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.GradesEntity;
import edu.depaul.cdm.se452.concept.database.mysql.repository.GradesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class GradesService implements IGradesService {

    @Autowired
    EntityManagerFactory emf;

    @Autowired
    private GradesRepository repository;

    @Override
    public List<GradesEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public GradesEntity update(GradesEntity student) {
        repository.save(student);
        return student;
    }

    @Override
    public GradesEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(int id) {repository.deleteById(id);
    }

    public List GS() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery(
                "SELECT s.FIRST_NAME, s.LAST_NAME, a.CLASS_ID, c.courseID, c.shortName, c.name, d.FIRST_NAME, d.LAST_NAME, g.GRADES_EARNED " +
                        "FROM GradesEntity g " +
                        "join CourseCatalogEntity a on g.CLASS_ID=a.CLASS_ID "+
                        "join CourseEntity c on c.courseID=a.COURSE_ID "+
                        "join StudentEntity s on g.STUDENT_ID=s.STUDENT_ID "+
                        "join ProfessorEntity d on a.PROFESSOR_ID=d.PROFESSOR_ID");
        return query.getResultList();
    }
}
