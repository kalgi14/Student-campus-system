package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "grades")
@Data
public class GradeEntity {

    @EmbeddedId
    private GradeKey id;

    @Column
    private int courseId;

    @Column
    private float grade_earned;

}
