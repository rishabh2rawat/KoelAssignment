package com.example.KoelAssignment.Model.Main.OutputModel;

import com.example.KoelAssignment.Model.Entity.Employee;
import com.example.KoelAssignment.Model.Entity.Teams;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
public class EmployeeGetOutputModel {

    private int empid;
    private String name;
    private String email;
    private String contactno;
    private String address;
    private Set<Teams> teams ;


    public static EmployeeGetOutputModel mapEmployee(Employee employee)
    {
        if(employee ==null)
        {
            return null;
        }
        EmployeeGetOutputModel employeeGetOutputModel=new EmployeeGetOutputModel();
        employeeGetOutputModel.setEmpid(employee.getEmpid());
        employeeGetOutputModel.setName(employee.getName());
        employeeGetOutputModel.setEmail(employee.getEmail());
        employeeGetOutputModel.setContactno(employee.getContactno());
        employeeGetOutputModel.setAddress(employee.getAddress());
        employeeGetOutputModel.setTeams(employee.getTeams());

        return employeeGetOutputModel;

    }

}
