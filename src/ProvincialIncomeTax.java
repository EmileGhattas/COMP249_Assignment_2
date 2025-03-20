public class ProvincialIncomeTax extends Deductions {
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
