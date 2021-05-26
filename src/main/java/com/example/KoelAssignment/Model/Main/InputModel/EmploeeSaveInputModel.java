package com.example.KoelAssignment.Model.Main.InputModel;

import com.example.KoelAssignment.Model.Entity.Employee;
import lombok.Data;


@Data
public class EmploeeSaveInputModel {

   // private int empid;
    private String name;
    private String email;
    private String contactNo;
    private String address;


    public static Employee mapEmployee(EmploeeSaveInputModel inputmodel)
    {
        if(inputmodel==null)
        {
            return null;
        }
        Employee employee =new Employee();
      //  employee.setEmpid(inputmodel.getEmpid());
        employee.setName(inputmodel.getName());
        employee.setEmail(inputmodel.getEmail());
        employee.setContactno(inputmodel.getContactNo());
        employee.setAddress(inputmodel.getAddress());

        return employee;
    }



}
