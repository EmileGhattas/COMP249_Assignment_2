//
// Assignment 2
// Question:
// Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
//

/**
 * calculates the Quebec Parental Insurance Plan (QPIP) premium.
 * the deduction is 0.494% of the gross salary, capped at a maximum of $494.12 annually.
 */
public class QPIP extends Deductions {

    /**
     * calculates the QPIP deduction based on gross salary.
     *
     * @param grossSalary the employee's annual gross salary
     * @return the QPIP deduction amount (maximum $494.12)
     */
    @Override
    public double calculateTax(double grossSalary) {
        double premium = grossSalary * 0.00494;
        return premium > 494.12 ? 494.12 : premium;
    }
}
