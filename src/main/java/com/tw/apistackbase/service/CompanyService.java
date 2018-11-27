package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyService {
    private List<Company> companies;

    public CompanyService() {
        this.companies = new ArrayList<>();
    }

    public List<Company> getAll() {
        return this.companies;
    }

    public void add(Company company) {
        this.companies.add(company);
    }

    public Company getCompany(int id) {
        for(Company company:this.companies){
            if(company.getId()==id){
                return company;
            }
        }
        return null;
    }
}
