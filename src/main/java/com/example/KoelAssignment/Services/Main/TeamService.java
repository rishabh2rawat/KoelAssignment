package com.example.KoelAssignment.Services.Main;

import com.example.KoelAssignment.Framework.Model.ResponseModel;
import com.example.KoelAssignment.Model.Entity.Employee;
import com.example.KoelAssignment.Model.Entity.TeamEmpRel;
import com.example.KoelAssignment.Model.Entity.Teams;
import com.example.KoelAssignment.Model.Main.InputModel.TeamSaveInputModel;
import com.example.KoelAssignment.Model.Main.OutputModel.EmployeeGetOutputModel;
import com.example.KoelAssignment.Model.Main.OutputModel.TeamGetOutputModel;
import com.example.KoelAssignment.Repository.EmployeeRepository;
import com.example.KoelAssignment.Repository.TeamEmpRelRepository;
import com.example.KoelAssignment.Repository.TeamRepository;
import com.example.KoelAssignment.Services.ServiceInterface.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeamService implements ITeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TeamEmpRelRepository teamEmpRelRepository;

    @Autowired
    private EmployeeService employeeService;



    @Override
    public List<TeamGetOutputModel> showAllTeams() {
        List<TeamGetOutputModel> teamGetOutputModelList=new ArrayList<>();

        teamRepository.findAll().forEach(obj->{
            teamGetOutputModelList.add(TeamGetOutputModel.mapTeam(obj));
        });
        return teamGetOutputModelList;
    }

    @Override
    public ResponseModel addEmployeeToTeam(int empid, int teamid) {

        Employee employee = employeeRepository.findAllByEmpid(empid);
        if (null == employee)
            return new ResponseModel(null, "Employee Does not Exist");

        Teams team = teamRepository.findAllByTeamid(teamid);
        if (null == employee)
            return new ResponseModel(null, "Team Does not Exist");


        TeamEmpRel teamEmpRel = new TeamEmpRel();
        teamEmpRel.setEmpid(empid);
        teamEmpRel.setTeamid(teamid);

        return new ResponseModel(teamEmpRelRepository.save(teamEmpRel), "Employee added To Team Success");


    }

    @Override
    public ResponseModel listEmployeefromTeam(int teamid) {
        Teams team=teamRepository.findAllByTeamid(teamid);
        if(null==team)
        {
            return new ResponseModel(null, "Team Does Not Exit");
        }
        List<Integer> emplist = teamEmpRelRepository.findAllByTeamid(teamid).stream().map(obj->obj.getEmpid())
                .collect(Collectors.toList());


        List<Employee> employeeList= employeeService.getEmployeeList(emplist);

        return new ResponseModel(employeeList,"Fethed all Employee");





    }

    @Override
    public ResponseModel createNewTeam(TeamSaveInputModel teamSaveInputModel) {
        if(null!=teamSaveInputModel) {

             return new ResponseModel(teamRepository.save(TeamSaveInputModel.mapTeam(teamSaveInputModel)), "added Succes");
        }
        else
        {
            return new ResponseModel(null, "Fields Can not be Empty");
        }
     }
}
