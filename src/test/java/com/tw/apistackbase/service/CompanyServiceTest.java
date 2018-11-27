package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyServiceTest {
    private CompanyService companyService;
    @Before
    public void setUp(){
        companyService = new CompanyService();
        Company.setCounter(1);
    }

    @Test
    public void should_add_company_and_search_all_companies (){
        Company company=new Company("company1",2,Arrays.asList(
                new Employee("emp1",20,"Male",8000),
                new Employee("emp2",21,"Female",7000)));
        companyService.add(company);

        List<Company> actual=companyService.getAll();

        List<Company> expected= new ArrayList<>();
        expected.add(company);

        assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    public void should_get_a_company (){
        Company company1=new Company("company1",2,Arrays.asList(
                new Employee("emp1",20,"Male",8000),
                new Employee("emp2",21,"Female",7000)));
        Company company2=new Company("company2",1,Arrays.asList(
                new Employee("emp3",21,"Male",9000)));
        companyService.add(company1);
        companyService.add(company2);

        Company actual=companyService.getCompany(2);

        assertEquals(company2,actual);
    }

    @Test
    public void should_get_employeee_of_a_company (){
        List<Employee> employees1=Arrays.asList(
                new Employee("emp1",20,"Male",8000),
                new Employee("emp2",21,"Female",7000));
        Company company1=new Company("company1",2,employees1);
        Company company2=new Company("company2",1,Arrays.asList(
                new Employee("emp3",21,"Male",9000)));
        companyService.add(company1);
        companyService.add(company2);

        List<Employee> actual=companyService.getCompanyEmployees(1);

        assertEquals(employees1,actual);
    }
}
