package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "courses")
@Data
public class CourseCatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "COURSE_ID")
    private int COURSE_ID;

    @Column (name = "SHORT_NAME")
    private String SHORT_NAME;

    @Column (name = "NAME")
    private String NAME;

    @Column (name = "DEPARTMENT")
    private String DEPARTMENT;

    @Column (name = "CREDITS")
    private int CREDITS;

    @Column (name = "GRADUATE")
    private int GRADUATE;
}

