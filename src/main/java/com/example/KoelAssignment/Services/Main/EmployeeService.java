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

        if(null == emploeeSaveInputModel) {
            return new ResponseModel(null, "Message Body Can not be Empty");
        }
        if(emploeeSaveInputModel.getEmail()==null||emploeeSaveInputModel.getEmail()=="")
        {
            return new ResponseModel(null, "Email Field is Mandatory");
        }
        if(emploeeSaveInputModel.getName()==null || emploeeSaveInputModel.getName()=="")
        {
            return new ResponseModel(null, "Name Field is Mandatory");
        }
        if(employeeRepository.existsByEmail(emploeeSaveInputModel.getEmail()))
        {
            return new ResponseModel(null, "Employee Already Exist with the same Email");
        }

        return new ResponseModel(employeeRepository.save(emploeeSaveInputModel.mapEmployee(emploeeSaveInputModel)), "Employee added Successfully");

    }

    @Override
    public ResponseModel findEmployeeByName(String name) {

        if(null==name || name=="" || name.length()==0)
        {
            return new ResponseModel(null, "Name Field Can not Be Empty");
        }

        List<Employee> employeeList =employeeRepository.findAllByName(name);

        if(null==employeeList || employeeList.isEmpty())
            return new ResponseModel(null,"No Employee Found with The Name Given");

        return new ResponseModel(employeeList,"Employee Found");
    }

    @Override
    public ResponseModel findEmployeeByEmail(String email) {

        if(null==email || email.length()==0)
            return new ResponseModel(null,"Email Can not Be Empty");

        List<Employee> employeeList= employeeRepository.findAllByEmail(email);

        if(null==employeeList || employeeList.isEmpty() )
            return new ResponseModel(null , "No Employee Found");

        return new ResponseModel(employeeList, "Employee Found");
    }


    // Return the List of Employee with the list of Employee Id
    public List<Employee> getEmployeeListFromEmpIdList(List<Integer> empIds)
    {
        return employeeRepository.findAllByEmpidIn(empIds);

    }


}
