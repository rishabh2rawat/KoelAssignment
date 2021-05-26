package com.example.KoelAssignment.Model.Main.OutputModel;

import com.example.KoelAssignment.Model.Entity.Teams;
import lombok.Data;

@Data
public class TeamGetOutputModel {

    private int teamid;
    private String name;
    private String desc;

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

        return outputModel;
    }


}
