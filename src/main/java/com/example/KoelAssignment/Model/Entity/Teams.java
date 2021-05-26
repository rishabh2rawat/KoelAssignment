package com.example.KoelAssignment.Model.Entity;
import lombok.Data;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Table(name="team_data")
@Entity
public class Teams {

    @Id
    @GeneratedValue
    @Column(name="teamid")
    private int teamid;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String desc;

//    @ManyToMany
//    @JoinTable(
//            name= "team_emp_rel",
//            joinColumns = @JoinColumn(name="teamid"),
//            inverseJoinColumns = @JoinColumn(name= "empid")
//    )
//    private Set<Employee> enrolledEmployee =new HashSet<>();




}
