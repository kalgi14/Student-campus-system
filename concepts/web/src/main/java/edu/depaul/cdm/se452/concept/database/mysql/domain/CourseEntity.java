package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "courses")
@Data
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "COURSE_ID")
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
