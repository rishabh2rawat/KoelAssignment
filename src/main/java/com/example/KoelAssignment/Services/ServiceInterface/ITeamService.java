package com.example.KoelAssignment.Services.ServiceInterface;

import com.example.KoelAssignment.Framework.Model.ResponseModel;
import com.example.KoelAssignment.Model.Main.InputModel.TeamSaveInputModel;
import com.example.KoelAssignment.Model.Main.OutputModel.TeamGetOutputModel;

import java.util.List;

public interface ITeamService {

    ResponseModel createNewTeam(TeamSaveInputModel teamSaveInputModel);

    List<TeamGetOutputModel> showAllTeams();

    ResponseModel addEmployeeToTeam(int empid, int teamid);

    ResponseModel listEmployeefromTeam(int teamid);
}
