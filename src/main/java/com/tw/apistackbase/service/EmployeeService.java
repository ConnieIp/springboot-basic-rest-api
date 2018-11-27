package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getAll() {
        return this.employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public Employee deleteEmployee(int id) {
        for(Employee e:this.employees) {
            if(e.getId()==id){
                this.employees.remove(e);
                return e;
            }
        }
        return null;
    }

    public Employee updateEmployee(int id, Employee employee) {
        for(Employee e:this.employees) {
            if(e.getId()==id){
                e.setName(employee.getName());
                e.setAge(employee.getAge());
                e.setGender(employee.getGender());
                e.setSalary(employee.getSalary());
                return e;
            }
        }
        return null;
    }

    public Employee getEmployee(int id) {
        for(Employee employee:this.employees){
            if(employee.getId()==id){
                return employee;
            }
        }
        return null;
    }
}
