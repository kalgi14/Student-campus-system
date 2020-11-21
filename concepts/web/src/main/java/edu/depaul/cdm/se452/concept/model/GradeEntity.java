package edu.depaul.cdm.se452.concept.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "grades")
@Data
public class GradeEntity {

    @EmbeddedId
    private GradeKey id;

    @Column (name = "COURSE_ID")
    private int courseId;

    @Column (name = "GRADES_EARNED")
    private float grade_earned;

}
