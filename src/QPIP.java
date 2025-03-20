public class QPIP extends Deductions {
    @Override
    public double calculateTax(double grossSalary) {
        double premium = grossSalary * 0.00494;
        return premium > 484.12 ? 484.12 : premium;
    }
}
