package com.tensketch.Pharma.Management.Service;

import com.tensketch.Pharma.Management.Model.Login;
import com.tensketch.Pharma.Management.Model.Customer;
import com.tensketch.Pharma.Management.Repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService{
    
    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer user = repo.findByMobile(Long.parseLong(username));    
        if (user == null) {
            throw new UsernameNotFoundException("Enter a valid Username");
        }
        return new Login(user);
    }
}
