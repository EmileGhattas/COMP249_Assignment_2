/**
 * Assignment 2
 *
 * Question:
 * Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
 */

/**
 * Represents an employee with payroll-related details such as
 * employee number, name, hours worked, hourly wage, gross salary, deductions, and net salary.
 */
public class Employee {

    /** Employee's unique ID number */
    long employeeNumber;

    /** Employee's first name */
    String firstName;
    /** Employee's last name */
    String lastName;

    /** Average weekly hours worked */
    double hoursWorked;
    /** Hourly wage */
    double hourlyWage;

    /** Computed annual gross salary (hoursWorked * hourlyWage * 52) */
    double grossSalary;

    /** Total deductions applied to the gross salary */
    double totalDeductions;
    /** Final net salary after deductions */
    double netSalary;

    /**
     * Constructs a new Employee and calculates their annual gross salary.
     *
     * @param employeeNumber the employee's unique ID number
     * @param firstName      the employee's first name
     * @param lastName       the employee's last name
     * @param hoursWorked    the average number of hours worked per week
     * @param hourlyWage     the hourly wage of the employee
     */
    public Employee(long employeeNumber, String firstName, String lastName, double hoursWorked, double hourlyWage) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
        // Annual gross salary = hours worked per week * hourly wage * 52 weeks
        this.grossSalary = hoursWorked * hourlyWage * 52;
    }

    /**
     * Sets the total deductions and calculates the net salary.
     *
     * @param totalDeductions the total amount to deduct from the gross salary
     */
    public void setDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
        this.netSalary = grossSalary - totalDeductions;
    }
}