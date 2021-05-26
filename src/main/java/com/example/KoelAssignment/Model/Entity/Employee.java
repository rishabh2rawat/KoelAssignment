package com.example.KoelAssignment.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name="employee")
@Entity
public class Employee {

    @Id
    @GeneratedValue
    @Column(name ="empid")
    private int empid;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="contactno")
    private String contactno;

    @Column(name="address")
    private String address;




//    @JsonIgnore
//    @ManyToMany(mappedBy = "enrolledEmployee")
//    private Set<Teams> Teams =new HashSet<>();



}
