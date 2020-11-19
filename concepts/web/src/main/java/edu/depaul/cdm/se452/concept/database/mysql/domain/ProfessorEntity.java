package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "professor")
@Data
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "FIRST_NAME")
    private String firstName;

    @Column (name = "LAST_NAME")
    private String lastName;

}
