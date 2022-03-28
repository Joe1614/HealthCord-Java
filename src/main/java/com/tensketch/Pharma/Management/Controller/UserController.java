package com.tensketch.Pharma.Management.Controller; //what this line will do?

import com.tensketch.Pharma.Management.Model.Customer;
import com.tensketch.Pharma.Management.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    
    @Autowired
    UserService service;

    @Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

    @PostMapping("/register")
    public String registerUser(Customer user){
        user.setPassword(encoder().encode(user.getPassword()));
        service.postUser(user);
        return "login";
    }

    // @PostMapping("/login")
    // public String login(@RequestParam String username, @RequestParam String password){
    //     return "home";
    // }
}
