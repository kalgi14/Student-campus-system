package edu.depaul.cdm.se452.concept.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collection;

@Controller
public class MainController {

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

//    public ModelAndView showDashboard(Authentication authentication) {

    @GetMapping("/")
    public ModelAndView showDashboard() {
        ModelAndView mv;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getAuthorities().toString(); //get logged in username
        if (name.equals("[ROLE_ADMIN]")){
            mv = new ModelAndView("admin/dashboard");
            mv.addObject("name", "ROLE_ADMIN");
        }
        else{
            mv = new ModelAndView("dashboard");
            mv.addObject("name", "ROLE_USER");
        }


//        mv.addObject("name", auth.getAuthorities());
//        mv.addObject("name", principal.isAuthenticated());
//        mv.addObject("name", principal.getDetails());
        return mv;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView postDashboard(Principal principal) {
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("name", principal.getName());
        return mv;
    }
//    public String getName(Authentication authentication, Principal principal) {
//        System.out.println(authentication.getName());
//        System.out.println("-----------------");
//        System.out.println(principal.getName());
//        return "";
//    }

    @GetMapping("/course_catalog")
    public ModelAndView courseCatalog() {
        ModelAndView mv = new ModelAndView("courseCatalog");
        return mv;
    }

    @GetMapping("/course")
    public ModelAndView course() {
        ModelAndView mv = new ModelAndView("course");
        return mv;
    }

    @GetMapping("/grade")
    public ModelAndView grade() {
        ModelAndView mv = new ModelAndView("grade");
        return mv;
    }

    @GetMapping("/tuition")
    public ModelAndView tuition() {
        ModelAndView mv = new ModelAndView("tuition");
        return mv;
    }

    @GetMapping("/take_course")
    public ModelAndView takeCourse() {
        ModelAndView mv = new ModelAndView("take-course");
        return mv;
    }

//    @GetMapping("/login")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

}