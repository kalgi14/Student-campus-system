package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "courses")
@Data
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int courseID;
    @Column
    String shortName;
    @Column
    String name;
    @Column
    String Department;
    @Column
    int credits;
    @Column
    boolean graduate;
}
