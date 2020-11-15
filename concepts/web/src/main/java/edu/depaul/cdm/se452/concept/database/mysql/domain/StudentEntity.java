package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int STUDENT_ID;

    @Column (name = "FIRST_NAME")
    private String FIRST_NAME;

    @Column (name = "LAST_NAME")
    private String LAST_NAME;

    @Column (name = "U_PASS")
    private int U_PASS;

    @Column (name = "CREDITS_TAKEN")
    private int CREDITS_TAKEN;

}
