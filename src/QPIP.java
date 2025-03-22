//---------------------------------------------------------------------------
// Assignment 2
// Question:
// Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
//---------------------------------------------------------------------------

/**
 * Assignment 2
 *
 * Question:
 * Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
 */

/**
 * Calculates the Quebec Parental Insurance Plan (QPIP) premium.
 * <p>
 * The deduction is 0.494% of the gross salary, capped at a maximum of $494.12 annually.
 * </p>
 */
public class QPIP extends Deductions {

    /**
     * Default constructor for QPP deduction calculator.
     */
    public QPIP() {
    }

    /**
     * Calculates the QPIP deduction based on the gross salary.
     *
     * @param grossSalary the employee's annual gross salary
     * @return the QPIP deduction amount (maximum $494.12)
     */
    @Override
    public double calculateTax(double grossSalary) {
        double premium = grossSalary * 0.00494;
        return premium > 484.12 ? 484.12 : premium; // On the instructions of Section PP, the maximum premium is 494.12 not 484.12
    }
}