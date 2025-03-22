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
 * Calculates the Quebec provincial income tax based on the 2025 tax brackets.
 * <p>
 * Applies a progressive tax rate based on the employee's gross salary.
 * </p>
 */
public class ProvincialIncomeTax extends Deductions {

    /**
     * Default constructor for QPP deduction calculator.
     */
    public ProvincialIncomeTax() {
    }

    /**
     * Calculates the provincial income tax to be deducted from the gross salary.
     *
     * @param grossSalary the employee's annual gross salary
     * @return the calculated provincial tax
     */
    @Override
    public double calculateTax(double grossSalary) {
        double tax = 0;

        if (grossSalary > 18571) {
            double taxable = Math.min(grossSalary, 53255) - 18571;
            tax += taxable * 0.14;
        }
        if (grossSalary > 53255) {
            double taxable = Math.min(grossSalary, 106495) - 53255;
            tax += taxable * 0.19;
        }
        if (grossSalary > 106495) {
            double taxable = Math.min(grossSalary, 129590) - 106495;
            tax += taxable * 0.24;
        }
        if (grossSalary > 129590) {
            double taxable = grossSalary - 129590;
            tax += taxable * 0.2575;
        }

        return tax;
    }
}