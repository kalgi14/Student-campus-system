package edu.depaul.cdm.se452.concept.view;

import edu.depaul.cdm.se452.concept.model.Enrollment;

import javax.validation.Valid;
import edu.depaul.cdm.se452.concept.controller.services.interfaces.IStudentService;
import edu.depaul.cdm.se452.concept.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("student")
@Controller
public class StudentController {


    @Qualifier("someBean")
    @Autowired
    IStudentService Service;

    @GetMapping
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("student");
        mv.addObject("student", new StudentEntity());
        return mv;
    }

    @PostMapping
    public String add(@Valid StudentEntity ent, BindingResult result, Model model) {
        try{

            Service.update(ent);
            model.addAttribute("update", new StudentEntity());
            model.addAttribute("message", "You have been registered successfully.");
            return "Student";
        }
        catch (Exception e){
            model.addAttribute("update", new Enrollment());
            model.addAttribute("message", "This Student, ");
            return "Student";
        }
    }
    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView mv = new ModelAndView("admin/student");
        mv.addObject("Student", Service.findAll());
        return mv;
    }
    @GetMapping("/dropout")
    public ModelAndView delete(@Valid StudentEntity ent) {
        ModelAndView mv = new ModelAndView("admin/student");
        mv.addObject("Student", delete(Service.findById(Integer.toString(ent.getStudentID()))));
        return mv;
    }


    @PostMapping("/student")
    public ModelAndView update(@Valid StudentEntity ent , BindingResult result) {
        ModelAndView mv = new ModelAndView("admin/addstudent");
        mv.addObject("Professor", Service.findAll());
        try{
            Service.update(ent);
            mv.addObject("message", "It has been updated successfully.");
            return mv;
        }
        catch (Exception e){
            mv.addObject("message",update(ent, result)  );
            return mv;
        }
    }
    @GetMapping("/student")
    public ModelAndView find(@Valid String ent , BindingResult result) {
        ModelAndView mv = new ModelAndView("admin/find");
        mv.addObject("Student", find(ent, result));
        return mv;
    }

}


