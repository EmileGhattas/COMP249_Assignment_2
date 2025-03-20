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
        // Annual gross salary = hours worked per week * hourly wage * 52 weeks
        this.grossSalary = hoursWorked * hourlyWage * 52;
    }

    public void setDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
        this.netSalary = grossSalary - totalDeductions;
    }
}
