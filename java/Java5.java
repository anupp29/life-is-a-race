/*Write a Java program to calculate electricity bill for commercial and domestic
plan using abstract class */

import java.util.*;

abstract class Bill {
    double units;

    public Bill(double units) {
        this.units = units;
    }

    public abstract double calcBill();
}

class Commercial extends Bill {
    public static final double RATE = 5.0;

    public Commercial(double units) {
        super(units);
    }

    @Override
    public double calcBill() {
        return units * RATE;
    }
}

class Domestic extends Bill {
    public static final double RATE = 3.0;

    public Domestic(double units) {
        super(units);
    }

    @Override
    public double calcBill() {
        return units * RATE;
    }
}

public class Java5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Electricity Bill Calculator");
        System.out.println("----------------------------");
        System.out.print("Enter number of units consumed: ");
        double units = sc.nextDouble();

        System.out.println("Choose Plan:");
        System.out.println("1. Commercial");
        System.out.println("2. Domestic");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = sc.nextInt();

        Bill bill;

        switch (choice) {
            case 1:
                bill = new Commercial(units);
                break;
            case 2:
                bill = new Domestic(units);
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        double totalBill = bill.calcBill();
        System.out.println("----------------------------");
        System.out.println("Total Bill Amount: $" + totalBill);
        System.out.println("----------------------------");

        sc.close();
    }
}

/*
 * PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> java Java5      
Electricity Bill Calculator
----------------------------
Enter number of units consumed: 120
Choose Plan:
1. Commercial
2. Domestic
Enter your choice (1 or 2): 1
----------------------------
Total Bill Amount: $600.0
----------------------------
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> java Java5
Electricity Bill Calculator
----------------------------
Enter number of units consumed: 120
Choose Plan:
1. Commercial
2. Domestic
Enter your choice (1 or 2): 2
----------------------------
Total Bill Amount: $360.0
----------------------------
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> 
 */