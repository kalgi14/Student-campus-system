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

    @Column
    private String FIRST_NAME;

    @Column
    private String LAST_NAME;

    @Column
    private int U_PASS;

    @Column
    private int CREDITS_TAKEN;

}
