//
// Assignment 1
// Question: Payroll Processor Assignment
// Written by: Your Name, Student ID: 12345678
//
// This class stores employee data and computes the annual gross salary.

public class Employee {
    long employeeNumber;
    String firstName;
    String lastName;
    double hoursWorked;
    double hourlyWage;
    double grossSalary;
    double totalDeductions;
    double netSalary;

    public Employee(long employeeNumber, String firstName, String lastName, double hoursWorked, double hourlyWage) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
        this.grossSalary = hoursWorked * hourlyWage * 52;
    }

    public void setDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
        this.netSalary = grossSalary - totalDeductions;
    }
}
