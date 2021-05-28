package com.example.KoelAssignment.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


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

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "enrolledEmployee" )
    @EqualsAndHashCode.Exclude @ToString.Exclude
    private Set<Teams> teams =new HashSet<>();


    public void addTeam(Teams team)
    {
        teams.add(team);
    }


}
