// ANUP SWARNSING PATIL 
// SYB B COMP SEM 4 
// ROLL NO 44

/* Write a Menu driven program in Java to implement banking application.
Application should read the customer name, account number, initial balance,
rate of interest, contact number and address field etc. Application should have
following methods.
i. createAccount()
ii. deposit()
iii. withdraw()
iv. computeInterest()
v. displayBalance() 
*/

import java.util.Scanner ;

class Ops {
    String name;
    int accNo;
    double bal;
    float roi;
    String contactNo;
    String addr;
    double minBal = 1000.0;

    public void createAccount(Scanner sc) {
        System.out.print("Enter Customer Name    : ");
        this.name = sc.nextLine();
        System.out.print("Enter Account Number   : ");
        this.accNo = sc.nextInt();
        System.out.print("Enter Initial Balance  : ");
        this.bal = sc.nextDouble();
        System.out.print("Enter Rate of Interest : ");
        this.roi = sc.nextFloat();
        System.out.print("Enter Contact Number   : ");
        sc.nextLine(); // consume the newline character
        this.contactNo = sc.nextLine();        
        System.out.print("Enter Address          : ");        
        this.addr = sc.nextLine();  
    }
    
    public void displayDetials() {
        System.out.println("\nCustomer Name    : " + this.name);
        System.out.println("Account Number   : " + this.accNo);
        System.out.println("Balance          : " + this.bal);
        System.out.println("Rate of Interest : " + this.roi);
        System.out.println("Contact Number   : " + this.contactNo);
        System.out.println("Address          : " + this.addr);
    }
    
    public void deposit(Scanner sc) {
        System.out.print("Enter Amount to Deposit: ");
        double amount = sc.nextDouble();
        this.bal += amount;
        System.out.println("Amount Deposited: " + amount + " | New Balance: " + this.bal);
    }

    public void withdraw(Scanner sc) {
        System.out.print("Enter Amount to Withdraw: ");
        double amount = sc.nextDouble();
        if (this.bal - amount < minBal) {
            System.out.println("Insufficient Balance. Minimum balance should be " + minBal);
        } else {
            this.bal -= amount;
            System.out.println("Amount Withdrawn: " + amount + " | New Balance: " + this.bal);
        }
    }

    public void interest(Scanner sc) {
        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();
        double interest = (this.bal * this.roi * years) / 100;
        System.out.println("Interest for " + years + " years: " + interest);
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + this.bal);
    }
};

class Java1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ops obj = new Ops();
        int choice;
        do {
            System.out.println("1. Create Account\n2. Deposit\n3. Withdraw\n4. Compute Interest\n5. Display Balance\n6. Display Details\n7. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume the newline character
            switch (choice) {
                case 1:
                    obj.createAccount(sc);
                    break;
                case 2:
                    obj.deposit(sc);
                    break;
                case 3:
                    obj.withdraw(sc);
                    break;
                case 4:
                    obj.interest(sc);
                    break;
                case 5:
                    obj.displayBalance();
                    break;
                case 6:
                    obj.displayDetials();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);
        sc.close();
    }
}


/*
 * Output:
 * 
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> java Bank
1. Create Account
2. Deposit
3. Withdraw
4. Compute Interest
5. Display Balance
6. Display Details
7. Exit

Enter your choice: 
1
Enter Customer Name: asp
Enter Account Number: 2307
Enter Initial Balance: 1200
Enter Rate of Interest: 21
Enter Contact Number: 231323242
Enter Address: nashik

1. Create Account
2. Deposit
3. Withdraw
4. Compute Interest
5. Display Balance
6. Display Details
7. Exit

Enter your choice:
2
Enter Amount to Deposit: 
230
Amount Deposited: 230.0 | New Balance: 1430.0

1. Create Account
2. Deposit
3. Withdraw
4. Compute Interest
5. Display Balance
6. Display Details
7. Exit

Enter your choice:
3
Enter Amount to Withdraw: 
1300
Insufficient Balance. Minimum balance should be 1000.0

1. Create Account
2. Deposit
3. Withdraw
4. Compute Interest
5. Display Balance
6. Display Details
7. Exit

Enter your choice:
3
Enter Amount to Withdraw: 
123
Amount Withdrawn: 123.0 | New Balance: 1307.0

1. Create Account
2. Deposit
3. Withdraw
4. Compute Interest
5. Display Balance
6. Display Details
7. Exit

Enter your choice:
4
Enter Number of Years: 
5
Interest for 5 years: 1372.35

1. Create Account
2. Deposit
3. Withdraw
4. Compute Interest
5. Display Balance
6. Display Details
7. Exit

Enter your choice:
5
Current Balance: 1307.0

1. Create Account
2. Deposit
3. Withdraw
4. Compute Interest
5. Display Balance
6. Display Details
7. Exit

Enter your choice:
6
Customer Name    : asp
Account Number   : 2307
Balance          : 1307.0
Rate of Interest : 21.0
Contact Number   : 231323242
Address          : nashik
   
1. Create Account
2. Deposit
3. Withdraw
4. Compute Interest
5. Display Balance
6. Display Details
7. Exit

Enter your choice: 
7
Exiting...
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> 

 */