package com.tensketch.Pharma.Management.Repo;

import java.util.List;

import com.tensketch.Pharma.Management.Model.MyHealth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyHealthRepo extends JpaRepository<MyHealth,Long>{
    List<MyHealth> findByuserId(Long id); 
}
