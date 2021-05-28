package com.example.KoelAssignment.Model.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name="team_data")
@Entity
public class Teams {

    @Id
    @GeneratedValue
    @Column(name="teamid")
    private int teamid;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String desc;


    @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinTable(
            name= "team_employee_relation",
            joinColumns = @JoinColumn(name="team_id"),
            inverseJoinColumns = @JoinColumn(name= "emp_id")
    )

    private Set<Employee> enrolledEmployee =new HashSet<>();


    public void addEmployee(Employee employee)
    {
        enrolledEmployee.add(employee);
    }


}
