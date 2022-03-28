package com.tensketch.Pharma.Management.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyHealth {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private long userId;
    private String symptoms;
    private String doctorName;  
    private String hospitalName;
    private String diagnosis;
    private String remedy;
    private String consultationDate; 
}
