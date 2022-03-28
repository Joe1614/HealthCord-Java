package com.tensketch.Pharma.Management.Repo;

import com.tensketch.Pharma.Management.Model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Customer,Long>{
    Customer findByMobile(long mobile);
    Customer findByMobileAndPassword(long mobile,String password);
}
