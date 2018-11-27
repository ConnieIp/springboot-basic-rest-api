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
}
