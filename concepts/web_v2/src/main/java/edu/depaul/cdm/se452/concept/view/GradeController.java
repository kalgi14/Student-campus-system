package edu.depaul.cdm.se452.concept.view;

import edu.depaul.cdm.se452.concept.controller.services.implimentation.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("grade")
@Controller

public class GradeController {

    @Qualifier("someBean")
    @Autowired
    GradeService gradeService;

    //Show all of the student's grades
    @GetMapping("/{id}")
    public ModelAndView showStudentGrades(@PathVariable("id") String studentId) {
        ModelAndView mv = new ModelAndView("grade");
        mv.addObject("grade", gradeService.findByStudent(studentId));
        return mv;
    }

}
