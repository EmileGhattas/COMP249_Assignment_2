//
// Assignment 2
// Question:
// Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
//

/**
 * calculates the Quebec Pension Plan (QPP) deduction.
 * the deduction is 10.8% of gross salary, capped at $7,700.40 annually.
 */
public class QPP extends Deductions {

    /**
     * calculates the QPP deduction based on gross salary.
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
