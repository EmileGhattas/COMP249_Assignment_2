//
// Assignment 2
// Question:
// Written by: Emile Ghattas (id: 40282552) and Ryan Khaled (id: 40307741)
//

/**
 * calculates the Employment Insurance (EI) premium deduction
 * for a given gross salary. the deduction is 1.64% of gross salary,
 * capped at a maximum of $1,077.48 annually.
 */
public class EI extends Deductions {

    /**
     * calculates the EI deduction based on the employee's gross salary.
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
