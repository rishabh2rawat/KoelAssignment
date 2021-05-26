package com.example.KoelAssignment.Model.Main.InputModel;
import com.example.KoelAssignment.Model.Entity.Teams;
import lombok.Data;


@Data
public class TeamSaveInputModel {

   // private int teamid;
    private String name;
    private String desc;

    public static Teams mapTeam(TeamSaveInputModel inputModel)
    {
        if(inputModel==null)
        {
            return null;
        }
        Teams team=new Teams();
     //   team.setTeamid(inputModel.getTeamid());
        team.setName(inputModel.getName());
        team.setDesc(inputModel.getDesc());

        return team;
    }

}
