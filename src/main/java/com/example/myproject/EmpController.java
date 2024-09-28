package com.example.myproject;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmpController {


    // List<Employee> employees = new ArrayList<>();
    // EmployeeService employeeService = new EmployeeServiceImpl(); 

    // Dependency injection
    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployee(){
        // List<Employee> employees = new ArrayList<>();
        // Employee emp = new Employee();
        // emp.setName("Shivam");
        // employees.add(null);
        // employees.add(emp);
        return employeeService.readEmployees();
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        // employees.add(employee);
        // employeeService.createEmployee(employee);
        
        // return "Saved Successfully";
        return employeeService.createEmployee(employee);
        
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if (employeeService.deleteEmployee(id))
            return "Delete Successfully";
        return "Not Found";
    }
    
}
