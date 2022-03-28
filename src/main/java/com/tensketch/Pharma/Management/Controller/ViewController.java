package com.tensketch.Pharma.Management.Controller;

import com.tensketch.Pharma.Management.Model.Login;
import com.tensketch.Pharma.Management.Service.MyHealthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @Autowired
    MyHealthService service;

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }  
    
    @GetMapping(value ={"/","/home"})
    public ModelAndView home(){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        Login login = (Login)loggedInUser.getPrincipal();
        mv.addObject("user",login.getUser());
        return mv;
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/healthcord")
    public ModelAndView myhealth(@RequestParam Long id){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("myhealth");
        mv.addObject("healthrecord", service.getById(id));
        Login login = (Login)loggedInUser.getPrincipal();
        mv.addObject("user",login.getUser());
        return mv;  
    }
}
