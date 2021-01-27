// Eric Li
// ITMD 411
// Lab 1

import java.util.Scanner;

public class AccountHolderTest{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your balance: ");
        double inputBalance = sc.nextDouble(); // Intakes user balance amount

        System.out.print("How much do you want to deposit? ");
        double deposit = sc.nextDouble(); // Intakes user deposit amount

        System.out.print("How much do you want to withdraw? ");
        double withdrawal = sc.nextDouble(); // Intakes user withdrawal amount

        AccountHolder newBalance = new AccountHolder(inputBalance, deposit, withdrawal);

        newBalance.deposit();
        newBalance.withdrawal();
        newBalance.monthlyInterest();

        System.out.printf("New balance: " + " $%.2f", newBalance.balance);

        sc.close();
    }
}