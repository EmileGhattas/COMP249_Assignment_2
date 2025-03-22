/**
 * Assignment 2
 *
 * Question:
 * Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
 */

/**
 * Abstract base class for all deduction types such as federal tax,
 * provincial tax, QPP, EI, and QPIP.
 * <p>
 * This class defines a method that must be implemented by all subclasses
 * to calculate a deduction based on the given gross salary.
 * </p>
 */
public abstract class Deductions {

    /**
     * Default constructor for QPP deduction calculator.
     */
    public Deductions() {
    }

    /**
     * Calculates the deduction amount based on the employee's gross salary.
     *
     * @param grossSalary the gross annual salary of the employee
     * @return the amount to be deducted
     */
    public abstract double calculateTax(double grossSalary);
}