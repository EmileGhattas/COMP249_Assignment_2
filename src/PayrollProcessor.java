//---------------------------------------------------------------------------
// Assignment 2
// Question:
// Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
//---------------------------------------------------------------------------

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

/*
 * This program reads employee payroll data from a file named "payroll.txt",
 * filters out invalid or improperly formatted records (e.g., incorrect number of fields,
 * non-numeric data, or hourly wage below minimum), and logs these to "payrollError.txt".
 * For each valid employee, it calculates the gross salary based on hours worked and hourly wage,
 * applies various government deductions (EI, QPIP, QPP, Provincial and Federal taxes),
 * and writes a detailed payroll report with net salaries to "payrollReport.txt".
 * The program is designed for batch processing of up to 1000 employee records.
 */

/**
 * The PayrollProcessor class is responsible for processing employee payroll data.
 * <p>
 * It performs the following tasks:
 * <ul>
 *   <li>Reads employee data from a file named "payroll.txt".</li>
 *   <li>Filters out invalid data and logs errors to "payrollError.txt".</li>
 *   <li>Calculates the gross salary and applies various deductions (EI, QPIP, QPP, Provincial Tax, Federal Tax).</li>
 *   <li>Generates a detailed payroll report in "payrollReport.txt" showing net salaries.</li>
 * </ul>
 */
public class PayrollProcessor {

    /**
     * Private constructor to prevent instantiation of this driver class.
     */
    private PayrollProcessor() {
    }

    /**
     *
     * Main method to execute the payroll processing logic.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        System.out.println("**************************************************************");
        System.out.println("||                                                          ||");
        System.out.println("||              Welcome to Payroll Processor                ||");
        System.out.println("||  by Ryan Khaled (40307741) and Emile Ghattas (40282552)  ||");
        System.out.println("||                                                          ||");
        System.out.println("**************************************************************\n");
        System.out.println(">Opening file payroll...\n");

        Employee[] employees = new Employee[1000];
        int validCount = 0;
        int totalLines = 0;
        int errorLines = 0;
        String[] errorLinesArray = new String[100];
        int errorIndex = 0;

        BufferedReader br = null;
        PrintWriter errorWriter = null;

        // Read payroll.txt and filter invalid lines
        try {
            br = new BufferedReader(new FileReader("payroll.txt"));
            errorWriter = new PrintWriter(new FileOutputStream("payrollError.txt"));
            System.out.println(">Reading file payroll...\n");

            String line;
            while ((line = br.readLine()) != null) {
                totalLines++;
                line = line.trim();
                if (line.equals("")) continue;

                String[] tokens = line.split("\\s+");
                if (tokens.length != 5) {
                    errorLines++;
                    errorWriter.println(line);
                    if (errorIndex < errorLinesArray.length) errorLinesArray[errorIndex++] = line;
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
                    if (validCount < employees.length) {
                        employees[validCount++] = emp;
                    } else {
                        System.err.println("Maximum employee count reached.");
                    }
                } catch (NumberFormatException | MinimumWageException e) {
                    errorLines++;
                    errorWriter.println(line);
                    if (errorIndex < errorLinesArray.length) errorLinesArray[errorIndex++] = line;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error while reading file: " + e.getMessage());
        } finally {
            try { if (br != null) br.close(); } catch (IOException ignored) {}
            if (errorWriter != null) errorWriter.close();
        }

        System.out.println("> Error lines found in file payroll:");
        for (int i = 0; i < errorIndex; i++) {
            System.out.println(errorLinesArray[i]);
        }
        System.out.println("\n> " + totalLines + " lines read from file payroll.");
        System.out.println("\n> " + errorLines + " lines written to error file.\n");

        // Calculate deductions
        System.out.println("> Calculating deductions");
        Deductions ei = new EI();
        Deductions qpip = new QPIP();
        Deductions qpp = new QPP();
        Deductions provincialTax = new ProvincialIncomeTax();
        Deductions federalTax = new FederalIncomeTax();

        for (int i = 0; i < validCount; i++) {
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

        System.out.println("\n> Writing report file");

        // Write final report
        PrintWriter reportWriter = null;
        try {
            reportWriter = new PrintWriter(new FileOutputStream("payrollReport.txt"));
            reportWriter.println("iDroid Solutions");
            reportWriter.println("-----------------------\n");
            reportWriter.printf("%-15s %-12s %-12s %-18s %-15s %-15s%n",
                    "Employee Number", "First name", "Last Name",
                    "Gross salary", "Deductions", "Net salary");
            reportWriter.println("-------------------------------------------------------------------------------------------------------");

            for (int i = 0; i < validCount; i++) {
                Employee emp = employees[i];
                String grossStr = String.format("$%,.2f", emp.grossSalary);
                String deductionsStr = String.format("$%,.2f", emp.totalDeductions);
                String netStr = String.format("$%,.2f", emp.netSalary);
                reportWriter.printf("%-15d %-12s %-12s %-18s %-15s %-15s%n",
                        emp.employeeNumber, emp.firstName, emp.lastName,
                        grossStr, deductionsStr, netStr);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error writing report file: " + e.getMessage());
        } finally {
            if (reportWriter != null) reportWriter.close();
        }

        System.out.println("\nThank you for using Payroll Processor. Program terminated.");
    }
}