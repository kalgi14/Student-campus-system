package edu.depaul.cdm.se452.concept.controller.services.implimentation;

import edu.depaul.cdm.se452.concept.model.Enrollment;
import edu.depaul.cdm.se452.concept.model.GradeEntity;
import edu.depaul.cdm.se452.concept.model.GradeKey;
import edu.depaul.cdm.se452.concept.controller.database.mysql.repository.EnrollmentRepository;
import edu.depaul.cdm.se452.concept.controller.database.mysql.repository.GradeRepository;
import edu.depaul.cdm.se452.concept.controller.services.interfaces.IGradeService;
import edu.depaul.cdm.se452.concept.controller.services.interfaces.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class GradeService implements IGradeService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private GradeRepository repository;

    @Override
    public List<GradeEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public GradeEntity update(GradeEntity grade) {
        repository.save(grade);
        return grade;
    }

    @Override
    public GradeEntity findById(GradeKey id) {
        return repository.findById(id).get();
    }

    @Override
    public List<GradeEntity> findByStudent(String studentID) {
        TypedQuery query = em.createQuery(
                "SELECT a " +
                        "FROM grades a " +
                        "WHERE a.Student_ID = ?1", int.class);
        query.setParameter(1, Integer.parseInt(studentID));
        return query.getResultList();
    }

    @Override
    public List<GradeEntity> findByClass(String classID) {
        TypedQuery query = em.createQuery(
                "SELECT a " +
                        "FROM grades a " +
                        "WHERE a.CLASS_ID = ?1", int.class);
        query.setParameter(1, Integer.parseInt(classID));
        return query.getResultList();
    }
}
