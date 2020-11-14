package edu.depaul.cdm.se452.concept.services.implimentation;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GradeKey implements Serializable {

    private int classId;
    private int studentId;

    public GradeKey(int classId, int studentId){
        this.classId = classId;
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
