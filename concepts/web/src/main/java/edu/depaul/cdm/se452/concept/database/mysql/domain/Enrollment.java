package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String CLASS_ID;

    @Column
    private String STUDENT_ID;

    @Column
    private String active = "1";
}
