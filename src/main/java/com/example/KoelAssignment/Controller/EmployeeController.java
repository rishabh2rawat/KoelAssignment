package com.example.KoelAssignment.Controller;

import com.example.KoelAssignment.Framework.Model.ResponseModel;
import com.example.KoelAssignment.Framework.Model.ResultModelApi;
import com.example.KoelAssignment.Model.Main.InputModel.EmploeeSaveInputModel;
import com.example.KoelAssignment.Model.Main.OutputModel.EmployeeGetOutputModel;
import com.example.KoelAssignment.Services.Main.EmployeeService;
import com.example.KoelAssignment.Services.ServiceInterface.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/koelAssignemt")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;


    @GetMapping("/getAllEmployee")
    public ResponseEntity<ResultModelApi> getAllEmployee()
    {
        List<EmployeeGetOutputModel> response= service.getEmployee();
        return new ResponseEntity<ResultModelApi>(new ResultModelApi(false,"Fetching All Employee Data",response), HttpStatus.OK );
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<ResultModelApi> addEmployee(@RequestBody EmploeeSaveInputModel emploeeSaveInputModel)
    {
       ResponseModel response =service.addNewEmployee(emploeeSaveInputModel);
       return new ResponseEntity<ResultModelApi> (new ResultModelApi(false,"Adding New Employee",response),HttpStatus.OK);

    }

}
