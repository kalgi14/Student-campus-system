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
public class EnrollmentController {


    @Qualifier("someBean")
    @Autowired
    GradeService.EnrollmentService IenrlService;

    @GetMapping
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("enrollment");
        mv.addObject("enroll", new Enrollment());
        return mv;
    }

    @PostMapping
    public String add(@Valid Enrollment enroll, BindingResult result, Model model) {
        try{
            IenrlService.update(enroll);
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

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView mv = new ModelAndView("admin/list-enrollment");
        mv.addObject("enrollment", IenrlService.findAll());
        return mv;
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") String enrollId, Model model) {
        Enrollment enroll = IenrlService.findById(Integer.parseInt(enrollId));
        model.addAttribute("enroll", enroll);
        return "admin/edit-student";
    }


    @PostMapping("/show")
    public ModelAndView update(@Valid Enrollment enrolls, BindingResult result) {
        ModelAndView mv = new ModelAndView("admin/list-enrollment");
        mv.addObject("enrollment", IenrlService.findAll());
        try{
            IenrlService.update(enrolls);
            mv.addObject("message", "It has been updated successfully.");
            return mv;
        }
        catch (Exception e){
            mv.addObject("message", "Something went wrong! try again.");
            return mv;
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String enrollId, Model model) {
        IenrlService.deleteById(Integer.parseInt(enrollId));
        return "redirect:/enrollment/show";
    }
}
