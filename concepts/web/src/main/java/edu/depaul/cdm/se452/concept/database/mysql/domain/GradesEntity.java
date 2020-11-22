package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "grades")
@Data
public class GradesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int CLASS_ID;

    @Column
    private float GRADES_EARNED;

    @Column
    private int STUDENT_ID;

}

