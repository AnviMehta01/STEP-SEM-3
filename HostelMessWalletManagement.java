package week6;

import java.util.Scanner;

public class HostelMessWalletManagement {

    static class MessWallet {

        private double balance;

        public MessWallet(double openingBalance) {

            if (openingBalance < 0) {
                System.out.println("Invalid opening balance. Starting with 0.");
                balance = 0;
            } else {
                balance = openingBalance;
            }
        }

        public void topUp(double amount) {

            if (amount <= 0) {
                System.out.println("Top-up amount must be positive.");
            } else {
                balance = balance + amount;
            }
        }

        public void deduct(double amount) {

            if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
            } else if (amount <= 0) {
                System.out.println("Deduct amount must be positive.");
            } else {
                balance = balance - amount;
            }
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter opening balance: ");
        double opening = sc.nextDouble();

        MessWallet wallet = new MessWallet(opening);

        System.out.print("Enter top-up amount: ");
        double topUp = sc.nextDouble();

        wallet.topUp(topUp);

        System.out.println("Balance after top-up: "
                + wallet.getBalance());

        System.out.print("Enter deduct amount: ");
        double deduct = sc.nextDouble();

        wallet.deduct(deduct);

        System.out.println("Final balance: "
                + wallet.getBalance());
    }
}