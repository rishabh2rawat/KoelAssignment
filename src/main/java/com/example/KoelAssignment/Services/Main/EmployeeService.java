package com.example.KoelAssignment.Services.Main;


import com.example.KoelAssignment.Framework.Model.ResponseModel;
import com.example.KoelAssignment.Model.Entity.Employee;
import com.example.KoelAssignment.Model.Main.InputModel.EmploeeSaveInputModel;
import com.example.KoelAssignment.Model.Main.OutputModel.EmployeeGetOutputModel;
import com.example.KoelAssignment.Repository.EmployeeRepository;
import com.example.KoelAssignment.Services.ServiceInterface.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<EmployeeGetOutputModel> getEmployee() {

        List<EmployeeGetOutputModel> employeeGetOutputModelList =new ArrayList<>();

            employeeRepository.findAll().forEach(obj-> {
                employeeGetOutputModelList.add(EmployeeGetOutputModel.mapEmployee(obj));
            });

        return employeeGetOutputModelList;
    }

    @Override
    public ResponseModel addNewEmployee(EmploeeSaveInputModel emploeeSaveInputModel) {

        if(null != emploeeSaveInputModel) {

            return new ResponseModel(employeeRepository.save(emploeeSaveInputModel.mapEmployee(emploeeSaveInputModel)), "Employee added Successfully");
        }
        else
        {
            return new ResponseModel(null,"Message Body Cn not be Empty");
        }
    }

    public List<Employee> getEmployeeList(List<Integer> empIds)
    {
        return employeeRepository.findAllByEmpidIn(empIds);
    }


}
