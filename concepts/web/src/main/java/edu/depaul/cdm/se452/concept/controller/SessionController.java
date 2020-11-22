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
        model.addAttribute("message", "We are setting session with value");
        model.addAttribute("sessionID", 2);
        return "sessions";
    }

    @GetMapping("/getsession")
    public String getSession(Model model) {
        model.addAttribute("message", "We are getting session's value");
        Integer sessionID = (Integer) model.asMap().get("sessionID");
        model.addAttribute("sessionID", sessionID);
        return "sessions";
    }
}
