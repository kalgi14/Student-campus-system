package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.TuitionEntity;
import edu.depaul.cdm.se452.concept.database.mysql.repository.TuitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class TuitionService implements ITuitionService {

    @Autowired
    EntityManagerFactory emf;

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
    public TuitionEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List findByStudent() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery(
                "SELECT a.tuition, a.due, a.quarter, d.FIRST_NAME, d.LAST_NAME " +
                        "FROM TuitionEntity a " +
                        "join StudentEntity d on a.studentID=d.STUDENT_ID");
        return query.getResultList();
    }

    @Override
    public void deleteById(int id) {repository.deleteById(id);
    }
}