package com.tensketch.Pharma.Management.Service;

import java.util.List;

import com.tensketch.Pharma.Management.Model.MyHealth;
import com.tensketch.Pharma.Management.Repo.MyHealthRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyHealthService {
        
    @Autowired
    MyHealthRepo repo;

    public List<MyHealth> getAll(){
        return repo.findAll();
    }
    
    public MyHealth addMyHealth(MyHealth myHealth){
        return repo.save(myHealth);
    }

    public List<MyHealth> getById(long id) {
        return repo.findByuserId(id);
    }
}
