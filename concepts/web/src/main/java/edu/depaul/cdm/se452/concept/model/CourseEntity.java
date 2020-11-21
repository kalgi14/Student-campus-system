package edu.depaul.cdm.se452.concept.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "courses")
@Data
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int courseID;
    @Column (name = "SHORT_NAME")
    String shortName;
    @Column (name = "NAME")
    String name;
    @Column (name = "DEPARTMENT")
    String Department;
    @Column (name = "CREDITS")
    int credits;
    @Column (name = "GRADUATE")
    boolean graduate;
}
