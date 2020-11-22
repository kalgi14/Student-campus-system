package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "professors")
@Data
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "PROFESSOR_ID")
    private int PROFESSOR_ID;

    @Column (name = "FIRST_NAME")
    private String FIRST_NAME;

    @Column (name = "LAST_NAME")
    private String LAST_NAME;

}
