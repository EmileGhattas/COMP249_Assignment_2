/**
 * Assignment 2
 *
 * Question:
 * Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
 */

/**
 * Calculates the federal income tax deduction for a given gross salary
 * based on the Canadian federal tax brackets for the year 2025.
 */
public class FederalIncomeTax extends Deductions {

    /**
     * Default constructor for QPP deduction calculator.
     */
    public FederalIncomeTax() {
    }

    /**
     * Calculates the federal tax using tiered tax rates based on the employee's gross salary.
     *
     * @param grossSalary the employee's gross annual salary
     * @return the total federal tax to be deducted
     */
    @Override
    public double calculateTax(double grossSalary) {
        double tax = 0;

        if (grossSalary > 16129) {
            double taxable = Math.min(grossSalary, 57375) - 16129;
            tax += taxable * 0.15;
        }
        if (grossSalary > 57375) {
            double taxable = Math.min(grossSalary, 114750) - 57375;
            tax += taxable * 0.205;
        }
        if (grossSalary > 114750) {
            double taxable = Math.min(grossSalary, 177882) - 114750;
            tax += taxable * 0.26;
        }
        if (grossSalary > 177882) {
            double taxable = Math.min(grossSalary, 253414) - 177882;
            tax += taxable * 0.29;
        }
        if (grossSalary > 253414) {
            double taxable = grossSalary - 253414;
            tax += taxable * 0.33;
        }

        return tax;
    }
}