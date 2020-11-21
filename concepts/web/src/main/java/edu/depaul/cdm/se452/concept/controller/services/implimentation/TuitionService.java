package edu.depaul.cdm.se452.concept.controller.services.implimentation;

import edu.depaul.cdm.se452.concept.model.TuitionEntity;
import edu.depaul.cdm.se452.concept.controller.database.mysql.repository.TuitionRepository;
import edu.depaul.cdm.se452.concept.controller.services.interfaces.ITuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class TuitionService implements ITuitionService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private TuitionRepository repository;

    @Override
    public List<TuitionEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public TuitionEntity update(TuitionEntity student) {
        repository.save(student);
        return student;
    }

    @Override
    public TuitionEntity findById(String id) {
        return repository.findById(UUID.fromString(id)).get();
    }

    @Override
    public List<TuitionEntity> findByStudent(String studentID) {
        TypedQuery query = em.createQuery(
                "SELECT a " +
                        "FROM tuition a " +
                        "WHERE a.Student_ID = ?1", String.class);
        query.setParameter(1, studentID);
        return query.getResultList();
    }

    @Override
    public void deleteById(String id) {repository.deleteById(UUID.fromString(id));
    }
}