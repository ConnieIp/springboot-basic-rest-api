package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
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
        List<Company> employees=companyService.getAll();
        return employees;
    }

    @PostMapping(produces = {"application/json"})
    public Company add(@RequestBody Company company) {
        companyService.add(company);
        return company;
    }

}
