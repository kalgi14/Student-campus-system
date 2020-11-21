package edu.depaul.cdm.se452.concept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("sessionID")
@Controller
public class SessionController {
    @GetMapping("/setsession")
    public String setSession(Model model) {
        model.addAttribute("name", "Kalgi");
        model.addAttribute("sessionID", 2);
        return "results";
    }

    @GetMapping("/getsession")
    public String getSession(Model model) {
        model.addAttribute("name", "Kalgi");
        Integer sessionID = (Integer) model.asMap().get("sessionID");
        model.addAttribute("sessionID", sessionID);
        return "results";
    }
}
