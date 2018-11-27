package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class EmployeeServiceTest {
    private EmployeeService employeeService;
    @Before
    public void setUp(){
        employeeService = new EmployeeService();
        Employee.setCounter(1);
    }
    @Test
    public void should_add_and_search_employees(){
        Employee employee=new Employee("emp1", 20,"Male", 8000);
        employeeService.addEmployee(employee);

        List<Employee> actual=employeeService.getAll();

        List<Employee> expected = Arrays.asList(employee);
        assertArrayEquals(expected.toArray(),actual.toArray());

    }

    @Test
    public void should_delete_employee(){
        Employee employee1=new Employee("emp1", 20,"Male", 8000);
        Employee employee2=new Employee("emp2", 23,"Female", 9000);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);

        Employee actual=employeeService.deleteEmployee(1);

        assertEquals(employee1,actual);

    }

    @Test
    public void should_update_employee(){
        Employee employee1=new Employee("emp1", 20,"Male", 8000);
        Employee employee2=new Employee("emp2", 23,"Female", 9000);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);

        Employee updateEmployee=new Employee("emp2", 24,"Female", 9500);
        Employee actual=employeeService.updateEmployee(2,updateEmployee);

        assertEquals(2,actual.getId());
        assertEquals("emp2",actual.getName());
        assertEquals(24,actual.getAge());
        assertEquals("Female",actual.getGender());
        assertEquals(9500,actual.getSalary());

    }

    @Test
    public void should_get_a_employee(){
        Employee employee1=new Employee("emp1", 20,"Male", 8000);
        Employee employee2=new Employee("emp2", 23,"Female", 9000);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);

        Employee actual=employeeService.getEmployee(2);

        assertEquals(employee2,actual);

    }

    @Test
    public void should_get_employees_with_gender(){
        Employee employee1=new Employee("emp1", 20,"Male", 8000);
        Employee employee2=new Employee("emp2", 23,"Female", 9000);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);

        List<Employee> actual=employeeService.getEmployeeWithGender("Male");

        assertEquals(Arrays.asList(employee1),actual);

    }
}
