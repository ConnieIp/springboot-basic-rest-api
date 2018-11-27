package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController() {
        employeeService = new EmployeeService();
    }


    @GetMapping(produces = {"application/json"})
    public List<Employee> getAll(@RequestParam(required = false) String gender,@RequestParam(required = false) String page, @RequestParam(required = false) String pageSize) {
        List<Employee> employees=new ArrayList<>();
        if(gender!=null) {
            employees = employeeService.getEmployeeWithGender(gender);
        }else if(page!=null && pageSize!=null){
            employees = employeeService.getPage(Integer.parseInt(page),Integer.parseInt(pageSize));
        }else{
            employees=employeeService.getAll();
        }
        return employees;
    }

    @GetMapping(path="/{id}", produces = {"application/json"})
    public Employee getEmployee(@PathVariable int id) {
        Employee employee=employeeService.getEmployee(id);
        return employee;
    }

    @PostMapping(produces = {"application/json"})
    public Employee add(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @DeleteMapping(path="/{id}", produces = {"application/json"})
    public Employee delete(@PathVariable int id) {
        Employee employee=employeeService.deleteEmployee(id);
        return employee;
    }

    @PutMapping(path="/{id}", produces = {"application/json"})
    public Employee put(@PathVariable int id,@RequestBody Employee employee) {
        Employee updatedEmployee=employeeService.updateEmployee(id,employee);
        return updatedEmployee;
    }


}
