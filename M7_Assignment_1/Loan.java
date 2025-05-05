public class Loan {
    private double loanAmount;
    private double annualInterestRate;
    private int numberOfYears;

    public Loan(double loanAmount, double annualInterestRate, int numberOfYears) {
        if (loanAmount <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero.");
        }
        if (annualInterestRate <= 0) {
            throw new IllegalArgumentException("Annual interest rate must be greater than zero.");
        }
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException(" Number of years must be greater than zero.");
        }
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
    }
    
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200; // Annual rate in percent /100 / 12.
        int numberOfPayments = numberOfYears * 12;

        if (monthlyInterestRate == 0) {
            return loanAmount / numberOfPayments;
        } else {
            return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
        }
    }

    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }
}