public class QPP extends Deductions {
    @Override
    public double calculateTax(double grossSalary) {
        double premium = grossSalary * 0.108;
        return premium > 7700.40 ? 7700.40 : premium;
    }
}
