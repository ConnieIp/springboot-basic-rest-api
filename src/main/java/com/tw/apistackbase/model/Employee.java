package com.tw.apistackbase.model;

public class Employee {
    private static int counter=1;
    private int id;
    private String name;
    private int age;
    private String gender;
    private int salary;

    public Employee() {
        this.id = counter++;
    }

    public Employee( String name, int age, String gender, int salary) {
        this.id = counter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Employee.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
