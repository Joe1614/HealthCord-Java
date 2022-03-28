package com.tensketch.Pharma.Management.Controller;

import java.util.List;

import com.tensketch.Pharma.Management.Model.MyHealth;
import com.tensketch.Pharma.Management.Service.MyHealthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myhealth")
public class MyHealthController {

    @Autowired
    MyHealthService service;
    
    @GetMapping
    public List<MyHealth> getMyHealth(@RequestParam Long id){
        return service.getById(id);
    }

    @PostMapping
    public MyHealth addMyHealth(MyHealth myhealth){
        return service.addMyHealth(myhealth);
    }
}
