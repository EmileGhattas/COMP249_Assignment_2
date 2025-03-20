public class EI extends Deductions {
    @Override
    public double calculateTax(double grossSalary) {
        double premium = (grossSalary / 100) * 1.64;
        return premium > 1077.48 ? 1077.48 : premium;
    }
}

