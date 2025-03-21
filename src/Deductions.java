//
// Assignment 2
// Question:
// Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
//

/**
 * abstract base class for all deduction types such as federal tax,
 * provincial tax, QPP, EI, and QPIP.
 * defines a method that must be implemented by all subclasses
 * to calculate a tax based on the given gross salary.
 */
public abstract class Deductions {
    /**
     * calculates the deduction amount based on the employee's gross salary.
     *
     * @param grossSalary the gross annual salary of the employee
     * @return the amount to be deducted
     */
    public abstract double calculateTax(double grossSalary);
}
