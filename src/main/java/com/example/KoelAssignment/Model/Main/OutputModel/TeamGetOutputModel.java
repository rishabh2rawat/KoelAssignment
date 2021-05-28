package com.example.KoelAssignment.Model.Main.OutputModel;

import com.example.KoelAssignment.Model.Entity.Employee;
import com.example.KoelAssignment.Model.Entity.Teams;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class TeamGetOutputModel {

    private int teamid;
    private String name;
    private String desc;
    private Set<Employee> enrolledEmployee;

    public static TeamGetOutputModel mapTeam(Teams team)
    {
        if(team==null)
        {
            return null;
        }
        TeamGetOutputModel outputModel=new TeamGetOutputModel();
        outputModel.setTeamid(team.getTeamid());
        outputModel.setName(team.getName());
        outputModel.setDesc(team.getDesc());
        outputModel.setEnrolledEmployee(team.getEnrolledEmployee());

        return outputModel;
    }






}
