/**
 * Assignment 2
 *
 * Question:
 * Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
 */

/**
 * Calculates the Quebec Pension Plan (QPP) deduction.
 * <p>
 * The deduction is 10.8% of the gross salary, capped at a maximum of $7,700.40 annually.
 * </p>
 */
public class QPP extends Deductions {

    /**
     * Default constructor for QPP deduction calculator.
     */
    public QPP() {
    }

    /**
     * Calculates the QPP deduction based on the gross salary.
     *
     * @param grossSalary the employee's annual gross salary
     * @return the QPP deduction amount (maximum $7,700.40)
     */
    @Override
    public double calculateTax(double grossSalary) {
        double premium = grossSalary * 0.108;
        return premium > 7700.40 ? 7700.40 : premium;
    }
}