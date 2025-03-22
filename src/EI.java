/**
 * Assignment 2
 *
 * Question:
 * Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
 */

/**
 * Calculates the Employment Insurance (EI) premium deduction.
 * <p>
 * The EI premium is 1.64% of the gross salary, capped at a maximum of $1,077.48 annually.
 * </p>
 */
public class EI extends Deductions {

    /**
     * Default constructor for QPP deduction calculator.
     */
    public EI() {
    }

    /**
     * Calculates the EI deduction based on the employee's gross salary.
     *
     * @param grossSalary the gross annual salary of the employee
     * @return the EI deduction amount (capped at $1,077.48)
     */
    @Override
    public double calculateTax(double grossSalary) {
        double premium = (grossSalary / 100) * 1.64;
        return premium > 1077.48 ? 1077.48 : premium;
    }
}