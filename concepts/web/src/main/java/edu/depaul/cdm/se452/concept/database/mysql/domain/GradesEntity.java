package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "grades")
@Data
public class GradesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int COURSE_ID;

    @Column
    private int CLASS_ID;

    @Column
    private float GRADES_EARNED;

    @Column
    private int STUDENT_ID;

}

