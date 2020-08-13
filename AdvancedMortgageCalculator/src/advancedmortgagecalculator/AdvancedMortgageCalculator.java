package advancedmortgagecalculator;

import java.util.Scanner;

public class AdvancedMortgageCalculator {
    
    public static double Principal;
    public static double Interest;
    public static double Period;

    public static void main(String[] args) {
        System.out.println("Welcome, this program calculates monthly mortgage payments");
        
        principal();
    }
    
    public static void principal() {    // Obtain mortgage principal amount
        Scanner console = new Scanner(System.in);
        
        System.out.print("Principal ($10000 - $50000000): ");
        Principal = console.nextDouble();   // User inputs principal amount which is then assigned to Principal
        
        if (Principal < 10000 || Principal > 50000000) {  // If statement sets a range for the principal amount
            System.out.println("Please enter a value between 10000 and 50000000");
            principal();
        }
        
        interest();
    }
    
    public static void interest() { // Obtain mortgage annual interest rate
        Scanner console = new Scanner(System.in);
        
        System.out.print("Annual Interest Rate (2% - 30%): ");
        Interest = console.nextDouble();    // User inputs annual interest rate which is then assigned to Interest
        
        if (Interest < 2 || Interest > 30) {  // If statement sets a range for the annual interest rate
            System.out.println("Please enter a value between 2 and 30");
            interest();
        }
        
        period();
    } 
    
    public static void period() {   // Obtain mortgage period
        Scanner console = new Scanner(System.in);
        
        System.out.print("Period (Years (2 - 30)): ");
        Period = console.nextDouble();    // User inputs annual interest rate which is then assigned to Interest
        
        if (Period <= 0 || Period > 30) {  // If statement sets a range for the period
            System.out.println("Please enter a value between 2 and 30");
            period();
        }
        
        calculation();
    }
    
    public static void calculation() {    // Calculate monthly mortgage payment
        // Conversion
        double monthlyInterestDecimal = Interest / 100 / 12;    // Conversion from annual percentage to Monthly decimal
        double numOfPayments = Period * 12;    // Conversion from period to number of payments
        
        // Calculation
        double payment = Principal * monthlyInterestDecimal * Math.pow(1 + monthlyInterestDecimal, numOfPayments) / (Math.pow(1 + monthlyInterestDecimal, numOfPayments) - 1);
        System.out.println("Monthly Mortgage Payment: $" + payment);
        System.exit(0);
    }
}
