//
// Assignment 2
// Question:
// Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
//

/**
 * represents an employee with relevant payroll information such as
 * worked hours, hourly wage, gross salary, deductions, and net salary.
 */
public class Employee {

    // employee's unique ID number
    long employeeNumber;

    // employee's first and last name
    String firstName;
    String lastName;

    // average weekly hours worked and hourly wage
    double hoursWorked;
    double hourlyWage;

    // computed annual gross salary (hoursWorked * hourlyWage * 52)
    double grossSalary;

    // total deductions and resulting net salary
    double totalDeductions;
    double netSalary;

    /**
     * constructs a new employee and calculates their annual gross salary.
     *
     * @param employeeNumber the employee's ID number
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param hoursWorked average number of hours worked per week
     * @param hourlyWage the hourly wage of the employee
     */
    public Employee(long employeeNumber, String firstName, String lastName, double hoursWorked, double hourlyWage) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
        // annual gross salary = hours worked per week * hourly wage * 52 weeks
        this.grossSalary = hoursWorked * hourlyWage * 52;
    }

    /**
     * sets the total deductions and calculates the net salary.
     *
     * @param totalDeductions the total amount to deduct from gross salary
     */
    public void setDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
        this.netSalary = grossSalary - totalDeductions;
    }
}
