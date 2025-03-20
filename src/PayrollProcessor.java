//-----------------------------------------------------------------
// Assignment 2
// Question:
// Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
//-----------------------------------------------------------------

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PayrollProcessor {
    public static void main(String[] args) {
        // Display welcome message.
        System.out.println("Welcome to Payroll Processor by Your Name (Student ID: 12345678).");
        System.out.println("Processing payroll file...\n");

        EmployeeArray employeeArray = new EmployeeArray();
        int totalLines = 0;
        int errorLines = 0;

        // Fixed-size array to store error lines (assumed maximum of 100 errors).
        String[] errorLinesArray = new String[100];
        int errorIndex = 0;

        // Read the payroll.txt file using BufferedReader and write invalid lines to payrollError.txt using PrintWriter.
        try (BufferedReader br = new BufferedReader(new FileReader("payroll.txt"));
             PrintWriter errorWriter = new PrintWriter(new FileWriter("payrollError.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                totalLines++;
                line = line.trim();
                if (line.equals("")) continue; // Skip empty lines

                // Split the line on one or more spaces.
                String[] tokens = line.split("\\s+");
                if (tokens.length != 5) {
                    errorLines++;
                    errorWriter.println(line);
                    if (errorIndex < errorLinesArray.length) {
                        errorLinesArray[errorIndex++] = line;
                    }
                    continue;
                }

                try {
                    long empNumber = Long.parseLong(tokens[0]);
                    String firstName = tokens[1];
                    String lastName = tokens[2];
                    double hoursWorked = Double.parseDouble(tokens[3].replace(',', '.'));
                    double hourlyWage = Double.parseDouble(tokens[4].replace(',', '.'));

                    if (hourlyWage < 15.75) {
                        throw new MinimumWageException("Hourly wage below legal minimum.");
                    }

                    Employee emp = new Employee(empNumber, firstName, lastName, hoursWorked, hourlyWage);
                    employeeArray.add(emp);
                } catch (NumberFormatException | MinimumWageException e) {
                    errorLines++;
                    errorWriter.println(line);
                    if (errorIndex < errorLinesArray.length) {
                        errorLinesArray[errorIndex++] = line;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading payroll file: " + e.getMessage());
            return;
        }

        // Display error lines found.
        System.out.println("> Error lines found in file payroll:");
        for (int i = 0; i < errorIndex; i++) {
            System.out.println(errorLinesArray[i]);
        }
        System.out.println("> " + totalLines + " lines read from file payroll.");
        System.out.println("> " + errorLines + " lines written to error file.\n");

        // Calculate deductions for each employee.
        System.out.println("> Calculating deductions");
        Deductions ei = new EI();
        Deductions qpip = new QPIP();
        Deductions qpp = new QPP();
        Deductions provincialTax = new ProvincialIncomeTax();
        Deductions federalTax = new FederalIncomeTax();

        Employee[] employees = employeeArray.getEmployees();
        for (int i = 0; i < employeeArray.size(); i++) {
            Employee emp = employees[i];
            double gross = emp.grossSalary;
            double totalDeduction = 0;
            totalDeduction += ei.calculateTax(gross);
            totalDeduction += qpip.calculateTax(gross);
            totalDeduction += qpp.calculateTax(gross);
            totalDeduction += provincialTax.calculateTax(gross);
            totalDeduction += federalTax.calculateTax(gross);
            emp.setDeductions(totalDeduction);
        }

        // Write the payroll report to payrollReport.txt using PrintWriter.
        System.out.println("> Writing report file");
        try (PrintWriter reportWriter = new PrintWriter(new FileWriter("payrollReport.txt"))) {
            reportWriter.println("iDroid Solutions");
            reportWriter.println("-----------------------");
            reportWriter.println();
            reportWriter.printf("%-15s %-12s %-12s %-18s %-15s %-15s%n",
                    "Employee Number", "First name", "Last Name", "Gross salary", "Deductions", "Net salary");
            reportWriter.println("-------------------------------------------------------------------------------------------------------");

            for (int i = 0; i < employeeArray.size(); i++) {
                Employee emp = employees[i];
                String grossStr = String.format("$%,.2f", emp.grossSalary);
                String deductionsStr = String.format("$%,.2f", emp.totalDeductions);
                String netStr = String.format("$%,.2f", emp.netSalary);

                reportWriter.printf("%-15d %-12s %-12s %-18s %-15s %-15s%n",
                        emp.employeeNumber,
                        emp.firstName,
                        emp.lastName,
                        grossStr,
                        deductionsStr,
                        netStr);
            }
        } catch (IOException e) {
            System.err.println("Error writing report file: " + e.getMessage());
        }

        System.out.println("\nThank you for using Payroll Processor. Program terminated.");
    }
}
