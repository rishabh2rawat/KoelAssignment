package com.example.KoelAssignment.Services.ServiceInterface;


import com.example.KoelAssignment.Framework.Model.ResponseModel;
import com.example.KoelAssignment.Model.Main.InputModel.EmploeeSaveInputModel;
import com.example.KoelAssignment.Model.Main.OutputModel.EmployeeGetOutputModel;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeGetOutputModel> getEmployee();

    ResponseModel addNewEmployee(EmploeeSaveInputModel emploeeSaveInputModel);


    ResponseModel findEmployeeByName(String name);

    ResponseModel findEmployeeByEmail(String email);
}
