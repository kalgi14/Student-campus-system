package edu.depaul.cdm.se452.concept.controller;

import edu.depaul.cdm.se452.concept.database.mysql.repository.CourseRepository;
import edu.depaul.cdm.se452.concept.database.mysql.repository.ProfessorRepository;
import edu.depaul.cdm.se452.concept.database.mysql.repository.TuitionRepository;
import edu.depaul.cdm.se452.concept.model.CourseCatalogService;
import edu.depaul.cdm.se452.concept.model.GradesService;
import edu.depaul.cdm.se452.concept.model.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CourseRepository courseRepository;


    @Autowired
    private ProfessorRepository professorRepository;

    @Qualifier("someBean2")
    @Autowired
    TuitionService tuiServ;

    @Qualifier("someBean3")
    @Autowired
    CourseCatalogService CCServ;

    @Qualifier("someBean4")
    @Autowired
    GradesService GServ;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("name", "Account Login");
        return mv;
    }
    @GetMapping("/logout")
    public ModelAndView logout() {
        ModelAndView mv = new ModelAndView("logout");
        return mv;
    }

    @GetMapping("/")
    public ModelAndView showDashboard() {
        ModelAndView mv;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            mv = new ModelAndView("dashboard");
            mv.addObject("name", auth.getName());
        return mv;
    }

    @GetMapping("/course_catalog")
    public ModelAndView courseCatalog() {
        ModelAndView mv = new ModelAndView("courseCatalog");
        List a = CCServ.CCS();
        mv.addObject("res", a.iterator());
        return mv;
    }

    @GetMapping("/course")
    public ModelAndView course() {
        ModelAndView mv = new ModelAndView("course");
        mv.addObject("courses", courseRepository.findAll());
        return mv;
    }

    @GetMapping("/professors")
    public ModelAndView prof() {
        ModelAndView mv = new ModelAndView("prof");
        mv.addObject("prof", professorRepository.findAll());
        return mv;
    }

    @GetMapping("/grade")
    public ModelAndView grade() {
        ModelAndView mv = new ModelAndView("grade");
        List a = GServ.GS();
        mv.addObject("res", a.iterator());
        return mv;
    }

    @GetMapping("/tuition")
    public ModelAndView tuition() {
        ModelAndView mv = new ModelAndView("tuition");
        List a = tuiServ.findByStudent();
        mv.addObject("res", a.iterator());
        return mv;
    }

}