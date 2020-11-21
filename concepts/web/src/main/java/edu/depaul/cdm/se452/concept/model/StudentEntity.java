package edu.depaul.cdm.se452.concept.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentID;

    @Column (name = "FIRST_NAME")
    private String fName;

    @Column (name = "LAST_NAME")
    private String lName;

    @Column (name = "U_PASS")
    private int upass;

    @Column (name = "CREDITS_TAKEN")
    private int completeCredits;

}
