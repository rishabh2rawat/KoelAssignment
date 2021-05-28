package com.example.KoelAssignment.Model.Main.InputModel;
import com.example.KoelAssignment.Model.Entity.Employee;
import com.example.KoelAssignment.Model.Entity.Teams;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


@Data
public class TeamSaveInputModel {


    private String name;
    private String desc;



    public static Teams mapTeam(TeamSaveInputModel inputModel)
    {
        if(inputModel==null)
        {
            return null;
        }
        Teams team=new Teams();
        team.setName(inputModel.getName());
        team.setDesc(inputModel.getDesc());


        return team;
    }


}
