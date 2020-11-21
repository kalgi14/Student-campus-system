package edu.depaul.cdm.se452.concept.model;

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
    private int tuition;

    @Column (name = "STUDENT_ID")
    private int studentID;

    @Column (name = "MONEY_DUE")
    private int due;

    @Column (name = "QUARTER")
    private String quarter;

}
