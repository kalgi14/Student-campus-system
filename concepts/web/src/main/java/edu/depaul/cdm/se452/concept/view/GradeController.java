package edu.depaul.cdm.se452.concept.view;

import edu.depaul.cdm.se452.concept.model.Enrollment;
import javax.validation.Valid;
import edu.depaul.cdm.se452.concept.controller.services.implimentation.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("enrollment")
@Controller

public class GradeController {

    @Qualifier("someBean")
    @Autowired
    GradeService.EnrollmentService IenrlService;

    

}
