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

    public List<Employee> getEmployeeWithGender(String gender) {
        List<Employee> result=new ArrayList<>();
        for(Employee employee:this.employees){
            if(employee.getGender().equals(gender)){
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> getPage(int page, int pageSize) {
        List<Employee> result=new ArrayList<>();
        int maxsize=((page*pageSize)<this.employees.size())?(page*pageSize):this.employees.size();
        for(int i=(page-1)*pageSize;i<maxsize;i++){
            result.add(this.employees.get(i));
        }
        return result;
    }
}
