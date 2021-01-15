package com.martcoding;


import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte Months_In_Year = 12;
        final byte PERCENT = 100;

        int loanAmount = 0;
        float monthlyInterest = 0;
        byte years = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Initial Loan Amount ($1K - $1M): ");
            loanAmount = scanner.nextInt();
            if (loanAmount >= 1000 && loanAmount <= 1000000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000. ");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / Months_In_Year;
                break;
            }
            System.out.println("Please enter a value greater than 0 and less than or equal to 10. ");
        }

        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * Months_In_Year;
                break;
            }
            System.out.println("Please enter a value between 1 and 30. ");
        }

        double mortgage = loanAmount
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) -1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);
    }
}
