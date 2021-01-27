// Eric Li
// ITMD 411
// Lab 1

public class AccountHolder{
    double balance, deposit, withdrawal;
    double annualInterestRate = 0.04;

    public AccountHolder(double balance, double deposit, double withdrawal) { // Constructor
        this.balance = balance;
        this.deposit = deposit;
        this.withdrawal = withdrawal;
        if (this.balance < 0) {
            System.out.println("Your balance cannot be negative. Please try again. "); // Error message
        }
    }

    public void monthlyInterest() {
        balance += balance * (this.annualInterestRate / 12.0); // Calculates interest
    }

    public void deposit() { // Adds deposit to balance
        balance += deposit;
    }

    public void withdrawal() {
        if ((balance + deposit) - withdrawal < 50) {
            System.out.println("Insufficient funds. ");
        } // Deducts withdrawal amount unless there is less than $50 in the account with the specified withdrawal
        else
            balance -= withdrawal;
    }
}