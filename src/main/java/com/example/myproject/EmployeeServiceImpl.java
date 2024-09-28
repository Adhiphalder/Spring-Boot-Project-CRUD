package com.example.myproject;

import java.util.List;
import java.util.ArrayList;


public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();


    @Override
    public String createEmployee(Employee employee) {
        employees.add(employee);
        return "Saved Successfully";

    }

    @Override
    public List<Employee> readEmployees() {

        return employees;

    }

    @Override
    // public boolean deleteEmployee(Long id) {

    //     employees.remove(id);
    //     return true;
    // }

    public boolean deleteEmployee(Long id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employees.remove(employee);
                return true;
            }
        }
        return false; 
    }

}
