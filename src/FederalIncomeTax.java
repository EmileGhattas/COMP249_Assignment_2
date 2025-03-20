public class FederalIncomeTax extends Deductions {
    @Override
    public double calculateTax(double grossSalary) {
        double tax = 0;
        if(grossSalary > 16129) {
            double taxable = Math.min(grossSalary, 57375) - 16129;
            tax += taxable * 0.15;
        }
        if(grossSalary > 57375) {
            double taxable = Math.min(grossSalary, 114750) - 57375;
            tax += taxable * 0.205;
        }
        if(grossSalary > 114750) {
            double taxable = Math.min(grossSalary, 177882) - 114750;
            tax += taxable * 0.26;
        }
        if(grossSalary > 177882) {
            double taxable = Math.min(grossSalary, 253414) - 177882;
            tax += taxable * 0.29;
        }
        if(grossSalary > 253414) {
            double taxable = grossSalary - 253414;
            tax += taxable * 0.33;
        }
        return tax;
    }
}
