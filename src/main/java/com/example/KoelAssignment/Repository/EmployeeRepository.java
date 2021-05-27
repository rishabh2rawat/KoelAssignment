package com.example.KoelAssignment.Repository;

import com.example.KoelAssignment.Model.Entity.Employee;
import com.example.KoelAssignment.Model.Main.OutputModel.EmployeeGetOutputModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findAllByEmpid(int empid);

    List<Employee> findAllByEmpidIn(List<Integer> empids);

    boolean existsByEmail(String email);

    List<Employee> findAllByName(String name);

    List<Employee> findAllByEmail(String email);

}
