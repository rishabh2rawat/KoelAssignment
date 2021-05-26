package com.example.KoelAssignment.Model.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="team_emp_rel")
public class TeamEmpRel {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name ="empid")
    private int empid;

    @Column(name = "teamid")
    private int teamid;




}
