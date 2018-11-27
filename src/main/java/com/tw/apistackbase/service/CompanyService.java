package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;

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

    public List<Employee> getCompanyEmployees(int id) {
        for(Company company:this.companies){
            if(company.getId()==id){
                return company.getEmployees();
            }
        }
        return null;
    }

    public Company delete(int id) {
        for(Company e:this.companies) {
            if(e.getId()==id){
                this.companies.remove(e);
                return e;
            }
        }
        return null;
    }

    public Company update(int id, Company company) {
        for(Company c:this.companies) {
            if(c.getId()==id){
                c.setCompanyName(company.getCompanyName());
                c.setEmployeesNumber(company.getEmployeesNumber());
                c.setEmployees(company.getEmployees());
                return c;
            }
        }
        return null;
    }

    public List<Company> getPage(int page, int pageSize) {
        List<Company> result=new ArrayList<>();
        int maxsize=((page*pageSize)<this.companies.size())?(page*pageSize):this.companies.size();
        for(int i=(page-1)*pageSize;i<maxsize;i++){
            result.add(this.companies.get(i));
        }
        return result;
    }
}
