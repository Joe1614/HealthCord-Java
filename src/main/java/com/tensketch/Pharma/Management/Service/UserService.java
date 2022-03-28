package com.tensketch.Pharma.Management.Service;

import com.tensketch.Pharma.Management.Model.Customer;
import com.tensketch.Pharma.Management.Repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;
    
    // public User getUser(String username){
    //     return repo.findByUsername(username);
    // }

    public Customer getUser(long mobile,String password){
        return repo.findByMobileAndPassword(mobile, password);
    }
    
    public void postUser(Customer user){
        repo.save(user);
    }
}
