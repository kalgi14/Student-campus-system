package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "classes")
@Data
public class CourseCatalogEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASS_ID")
    private int CLASS_ID;

    @Column(name = "COURSE_ID")
    private int COURSE_ID;

    @Column(name = "PROFESSOR_ID")
    private int PROFESSOR_ID;

}