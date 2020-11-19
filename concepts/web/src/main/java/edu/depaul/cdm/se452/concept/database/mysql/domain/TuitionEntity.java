package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "tuition")
@Data
public class TuitionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "TUITION_ID")
    private int TUITION_ID;

    @Column (name = "STUDENT_ID")
    private int STUDENT_ID;

    @Column (name = "MONEY_DUE")
    private int MONEY_DUE;

    @Column (name = "QUARTER")
    private String QUARTER;

}
