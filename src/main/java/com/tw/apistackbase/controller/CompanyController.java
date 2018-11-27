package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController() {
        companyService = new CompanyService();
    }

    @GetMapping(produces = {"application/json"})
    public List<Company> getAll() {
        List<Company> companies=companyService.getAll();
        return companies;
    }

    @GetMapping(path="/{id}", produces = {"application/json"})
    public Company getCompany(@PathVariable int id) {
        Company company=companyService.getCompany(id);
        return company;
    }

    @GetMapping(path="/{id}/employees", produces = {"application/json"})
    public List<Employee> getCompanyEmployees(@PathVariable int id) {
        List<Employee> employees=companyService.getCompanyEmployees(id);
        return employees;
    }

    @PostMapping(produces = {"application/json"})
    public Company addCompany(@RequestBody Company company) {
        companyService.add(company);
        return company;
    }

    @DeleteMapping(path="/{id}", produces = {"application/json"})
    public Company deleteCompany(@PathVariable int id) {
        Company company=companyService.delete(id);
        return company;
    }

    @PutMapping(path="/{id}", produces = {"application/json"})
    public Company put(@PathVariable int id,@RequestBody Company company) {
        Company updatedCompany=companyService.update(id,company);
        return updatedCompany;
    }

}
