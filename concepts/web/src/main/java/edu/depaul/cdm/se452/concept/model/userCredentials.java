package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.userLogin;
import edu.depaul.cdm.se452.concept.database.mysql.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.security.Principal;
import java.util.List;

@ConditionalOnProperty(name = "datasource", havingValue = "db")
@Service
public class userCredentials implements IUsersService{

//    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    String name = auth.getName(); //get logged in username


    @Autowired
    EntityManagerFactory emf;

    @Autowired
    private UsersRepo repository;

    @Override
    public List<userLogin> findAll() {
        return repository.findAll();
    }

    @Override
    public userLogin update(userLogin enrol) {
        repository.save(enrol);
        return enrol;
    }

    @Override
    public userLogin findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<userLogin> JPQLQuery() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select "
                +"s.username as username,s.password as password,s.role as role, "
                +"s.enabled as enabled,d.FIRST_NAME as FIRST_NAME,d.LAST_NAME as LAST_NAME "
                +" from userLogin s " +
                " join StudentEntity d on s.user_id=d.STUDENT_ID");
        @SuppressWarnings("unchecked")
        List<userLogin> list = query.getResultList();
        em.close();

        return list;
    }

    //        if (name.equals("[ROLE_ADMIN]")){
//            mv = new ModelAndView("admin/dashboard");
//            mv.addObject("name", "ROLE_ADMIN");
//        }
//        else{
//            mv = new ModelAndView("dashboard");
//            mv.addObject("name", "ROLE_USER");
//        }
//        RequestContextHolder.currentRequestAttributes().getSessionId();

}
