/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aashgar
 */
public class Employee {
    private int id;
    private String name;
    private String dept;
    private double salary;
    private List<Employee> subordinates;

    public Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        this.subordinates.add(employee);
    }
    
    public void removeEmployee(Employee employee){
        this.subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }


    @Override
    public String toString() {
        return this.id + "  " + this.name + "  " + this.dept + "  " + this.salary;
    }
    
    
}
