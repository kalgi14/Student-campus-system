package edu.depaul.cdm.se452.concept.view;

import edu.depaul.cdm.se452.concept.controller.services.implimentation.EnrollmentService;
import edu.depaul.cdm.se452.concept.controller.services.implimentation.StudentService;
import edu.depaul.cdm.se452.concept.model.Enrollment;
import edu.depaul.cdm.se452.concept.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("admin")
@Controller
public class AdminController {

    @Qualifier("someBean")
    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public String add(@Valid StudentEntity student, BindingResult result, Model model) {
        try{
            studentService.update(student);
            model.addAttribute("enroll", new Enrollment());
            model.addAttribute("message", "You have been registered successfully.");
            return "enrollment";
        }
        catch (Exception e){
            model.addAttribute("enroll", new Enrollment());
            model.addAttribute("message", "You had taken this course! try new course.");
            return "enrollment";
        }
    }

}
