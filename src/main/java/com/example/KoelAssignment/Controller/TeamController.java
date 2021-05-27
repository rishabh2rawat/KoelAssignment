package com.example.KoelAssignment.Controller;

import com.example.KoelAssignment.Framework.Model.ResponseModel;
import com.example.KoelAssignment.Framework.Model.ResultModelApi;
import com.example.KoelAssignment.Model.Main.InputModel.TeamSaveInputModel;
import com.example.KoelAssignment.Model.Main.OutputModel.TeamGetOutputModel;
import com.example.KoelAssignment.Services.ServiceInterface.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/koelAssignemt")
public class TeamController {

    @Autowired
    private ITeamService service;

    @PostMapping("/newTeam")
    public ResponseEntity<ResultModelApi> createNewTeam(@RequestBody TeamSaveInputModel teamSaveInputModel)
    {

            ResponseModel response = service.createNewTeam(teamSaveInputModel);
            return new ResponseEntity<ResultModelApi>(new ResultModelApi(false,response.getMessage(),response),HttpStatus.OK);

    }

    @GetMapping("/showTeams")
    public ResponseEntity<ResultModelApi> showAllTeams()
    {

            List<TeamGetOutputModel> response = service.showAllTeams();

        return new ResponseEntity<ResultModelApi>(new ResultModelApi(false,"Fetching All Team info",response),HttpStatus.OK);
    }


    @PostMapping("/add/{empid}/team/{teamid}")
    public ResponseEntity<ResultModelApi> addEmployeeToTeam(
            @PathVariable int empid,
            @PathVariable int teamid)
    {

        ResponseModel response = service.addEmployeeToTeam(empid,teamid);

        return new ResponseEntity<ResultModelApi>(new ResultModelApi(false,"Adding Employee To Team",response.getMessage()),HttpStatus.OK);
    }

    @GetMapping("/listEmployee/{teamid}")

    public ResponseEntity<ResultModelApi> listEmployeefromTeam(@PathVariable int teamid)
    {
        ResponseModel response=service.listEmployeefromTeam(teamid);

        return new ResponseEntity<ResultModelApi>(new ResultModelApi(false,response.getMessage(),response),HttpStatus.OK);

    }



}
