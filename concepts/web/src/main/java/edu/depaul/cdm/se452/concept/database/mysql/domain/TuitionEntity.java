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

    @Column
    private int TUITION_ID;

    @Column
    private int STUDENT_ID;

    @Column
    private int MONEY_DUE;

    @Column
    private String QUARTER;

}
