package com.hhblog.hanghae.controller;

import com.hhblog.hanghae.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
                model.addAttribute("userName", userDetails.getUser().getUsername());
        }
//        else {
//            model.addAttribute("userName", " ");
//        }
         return "index";

//    @GetMapping("/")
//    public String home() {
//        return "index";
//    }
    }

    @GetMapping("/write")
    public String write(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("userName", userDetails.getUser().getUsername());
        }
//        else {
//            model.addAttribute("userName", " ");
//        }
        return "write";

//    @GetMapping("/")
//    public String home() {
//        return "index";
//    }
    }
}