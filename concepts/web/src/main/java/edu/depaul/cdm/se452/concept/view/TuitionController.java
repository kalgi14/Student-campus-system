package edu.depaul.cdm.se452.concept.view;

import edu.depaul.cdm.se452.concept.controller.services.implimentation.EnrollmentService;
import edu.depaul.cdm.se452.concept.controller.services.implimentation.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("tuition")
@Controller
public class TuitionController {

    @Qualifier("someBean")
    @Autowired
    TuitionService tuitionService;

    //Show all of the student's grades
    @GetMapping("/{id}")
    public ModelAndView showDue(@PathVariable("id") String studentId) {
        ModelAndView mv = new ModelAndView("grade");
        mv.addObject("tuition", tuitionService.findByStudent(studentId));
        return mv;
    }

}
