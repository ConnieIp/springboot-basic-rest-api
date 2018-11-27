package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyServiceTest {
    private CompanyService companyService;
    @Before
    public void setUp(){
        companyService = new CompanyService();
    }
    @Test
    public void should_add_company_and_search_all_companies (){
        Company company=new Company("company1",2,Arrays.asList(new Employee("emp1",20,"Male",8000)));
        companyService.add(company);

        List<Company> actual=companyService.getAll();

        List<Company> expected= new ArrayList<>();
        expected.add(company);

        assertArrayEquals(expected.toArray(),actual.toArray());
    }
}
