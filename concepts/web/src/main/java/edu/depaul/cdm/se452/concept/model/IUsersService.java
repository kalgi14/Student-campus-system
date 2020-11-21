package edu.depaul.cdm.se452.concept.model;

import edu.depaul.cdm.se452.concept.database.mysql.domain.userLogin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUsersService {
    public List<userLogin> findAll();

    public userLogin update(userLogin ce);

    public userLogin findById(int id);

    public void deleteById(int id);

    public List<userLogin> JPQLQuery();
}
