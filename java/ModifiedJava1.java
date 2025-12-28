// ANUP SWARNSING PATIL
// SY COMP SEM 4
// ROLL NO 44

// Added LOgin System And used  array of object to store the multiple accounts

import java.util.*;

class Ops {
    String name;
    int acc_no;
    double init_bal;
    float roi;
    long contact_no;
    String address;
    double min_bal = 1000;

    public void createAccount(Scanner sc) {
        System.out.print("Enter Name: ");
        this.name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        this.acc_no = sc.nextInt();
        System.out.print("Enter Initial Balance: ");
        this.init_bal = sc.nextDouble();
        System.out.print("Enter Rate of Interest: ");
        this.roi = sc.nextFloat();
        sc.nextLine(); 
        System.out.print("Enter Contact Number: ");
        this.contact_no = sc.nextLong();
        sc.nextLine(); 
        System.out.print("Enter Address: ");
        this.address = sc.nextLine();
        System.out.println("Account Created Successfully!\n");
    }

    public void deposit(Scanner sc) {
        System.out.print("Enter Deposit Amount: ");
        double deposit = sc.nextDouble();
        this.init_bal += deposit;
        System.out.println("Amount " + deposit + " deposited successfully in Account Number " + acc_no + ".\n");
    }

    public void withdraw(Scanner sc) {
        System.out.print("Enter Withdrawal Amount: ");
        double withdraw = sc.nextDouble();
        double temp = this.init_bal - withdraw;
        if (temp >= min_bal) {
            this.init_bal = temp;
            System.out.println("Amount " + withdraw + " withdrawn successfully from Account Number " + acc_no + ".\n");
        } else {
            System.out.println("Transaction failed: Minimum balance requirement not met.\n");
        }
    }

    public void displayBal() {
        System.out.println("Current Balance: " + init_bal + "\n");
    }

    public void roi(Scanner sc) {
        double interest = init_bal * roi * 0.01;
        this.init_bal += interest;
        System.out.println("Balance updated with interest at " + roi + "%.\n");
    }

    public void displayDetails() {
        System.out.println("+------------------------------+");
        System.out.println("| Name     : " + name);
        System.out.println("| Acc No.  : " + acc_no);
        System.out.println("| Balance  : " + init_bal);
        System.out.println("| ROI      : " + roi);
        System.out.println("| Contact  : " + contact_no);
        System.out.println("| Address  : " + address);
        System.out.println("+------------------------------+");
    }
}

class ModifiedJava1 {
    public static void main(String args[]) {
        System.out.println("Welcome to the Bank System\n");
        Scanner sc = new Scanner(System.in);
        Ops[] accounts = new Ops[10000]; 
        int accountCount = 0;

        while (true) {
            System.out.println("    -    MENU    -    ");
            System.out.println("1. Create Account");
            System.out.println("2. Login to Account");
            System.out.println("3. Display All");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    if (accountCount < accounts.length) {
                        accounts[accountCount] = new Ops();
                        System.out.println("\nCreating Account\nEnter your Details:");
                        accounts[accountCount].createAccount(sc);
                        accountCount++;
                    } else {
                        System.out.println("Account limit reached. Cannot create more accounts.\n");
                    }
                    break;

                case 2:
                    System.out.print("\nEnter Account Number to Login: ");
                    int accNo = sc.nextInt();
                    sc.nextLine(); 
                    Ops currentAccount = null;

                    for (Ops account : accounts) {
                        if (account != null && account.acc_no == accNo) {
                            currentAccount = account;
                            break;
                        }
                    }

                    if (currentAccount != null) {
                        System.out.println("\nLogin Successful!\n");
                        int iter = 1;
                        while (iter == 1) {
                            System.out.println("    -    ACCOUNT MENU    -    ");
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Calculate Interest");
                            System.out.println("4. Display Balance");
                            System.out.println("5. Display Details");
                            System.out.println("6. Logout");
                            System.out.print("\nEnter your choice: ");
                            int ch = sc.nextInt();
                            sc.nextLine(); 

                            switch (ch) {
                                case 1:
                                    System.out.println("\nDeposit Initiated");
                                    currentAccount.deposit(sc);
                                    break;
                                case 2:
                                    System.out.println("\nWithdrawal Initiated");
                                    currentAccount.withdraw(sc);
                                    break;
                                case 3:
                                    System.out.println("\nCalculating Interest");
                                    currentAccount.roi(sc);
                                    break;
                                case 4:
                                    System.out.println("\nDisplaying Balance");
                                    currentAccount.displayBal();
                                    break;
                                case 5:
                                    System.out.println("\nDisplaying Account Details");
                                    currentAccount.displayDetails();
                                    break;
                                case 6:
                                    iter = 0;
                                    System.out.println("\nLogged out successfully!\n");
                                    break;
                                default:
                                    System.out.println("\nInvalid choice, please try again.\n");
                            }
                        }
                    } else {
                        System.out.println("Account not found. Please try again.\n");
                    }
                    break;
				
				case 3:
						System.out.println("\nDisplaying All Accounts:\n");
						System.out.println("+---------------------+------------------+--------------+--------+------------------+----------------------+");
						System.out.println("| Name                | Account Number   | Balance      | ROI    | Contact Number    | Address              |");
						System.out.println("+---------------------+------------------+--------------+--------+------------------+----------------------+");

						// Loop through all accounts and print details
						for (Ops account : accounts) {
							if (account != null) {  // Only print details of accounts that have been created
								System.out.println("| " + account.name + "        | " + account.acc_no + "        | " + account.init_bal + "        | " + account.roi + "    | " + account.contact_no + "        | " + account.address + "     |");
							}
						}

						System.out.println("+---------------------+------------------+--------------+--------+------------------+----------------------+");
						break;

                case 4:
                    System.out.println("\nThank You for using the Bank System!");
                    sc.close();
                    return;

                default:
                    System.out.println("\nInvalid choice, please try again.\n");
            }
        }
    }
}



/*
 *S C:\Users\hp\Desktop\CARP\life-is-a-race\java> java ModifiedJava1
Welcome to the Bank System

    -    MENU    -    
1. Create Account
2. Login to Account
3. Display All
4. Exit

Enter your choice: 1

Creating Account
Enter your Details:
Enter Name: asp
Enter Account Number: 21
Enter Initial Balance: 1200
Enter Rate of Interest: 4
Enter Contact Number: 43443452
Enter Address: nashik
Account Created Successfully!

    -    MENU    -
1. Create Account
2. Login to Account
3. Display All
4. Exit

Enter your choice: 2

Enter Account Number to Login: 21

Login Successful!

    -    ACCOUNT MENU    -
1. Deposit
2. Withdraw
3. Calculate Interest
4. Display Balance
5. Display Details
6. Logout

Enter your choice: 1

Deposit Initiated
Enter Deposit Amount: 12908
Amount 12908.0 deposited successfully in Account Number 21.

    -    ACCOUNT MENU    -
1. Deposit
2. Withdraw
3. Calculate Interest
4. Display Balance
5. Display Details
6. Logout

Enter your choice: 4

Displaying Balance
Current Balance: 14108.0

    -    ACCOUNT MENU    -
1. Deposit
2. Withdraw
3. Calculate Interest
4. Display Balance
5. Display Details
6. Logout

Enter your choice: 6

Logged out successfully!

    -    MENU    -
1. Create Account
2. Login to Account
3. Display All
4. Exit

Enter your choice: 1

Creating Account
Enter your Details:
Enter Name: jar
Enter Account Number: 22
Enter Initial Balance: 23098
Enter Rate of Interest: 4
Enter Contact Number: 35342
Enter Address: jalgaon
Account Created Successfully!

    -    MENU    -
1. Create Account
2. Login to Account
3. Display All
4. Exit

Enter your choice: 2

Enter Account Number to Login: 22

Login Successful!

    -    ACCOUNT MENU    -
1. Deposit
2. Withdraw
3. Calculate Interest
4. Display Balance
5. Display Details
6. Logout

Enter your choice: 4

Displaying Balance
Current Balance: 23098.0

    -    ACCOUNT MENU    -
1. Deposit
2. Withdraw
3. Calculate Interest
4. Display Balance
5. Display Details
6. Logout

Enter your choice: 12000

Invalid choice, please try again.

    -    ACCOUNT MENU    -
1. Deposit
2. Withdraw
3. Calculate Interest
4. Display Balance
5. Display Details
6. Logout

Enter your choice: 4

Displaying Balance
Current Balance: 23098.0

    -    ACCOUNT MENU    -
1. Deposit
2. Withdraw
3. Calculate Interest
4. Display Balance
5. Display Details
6. Logout

Enter your choice: 3

Calculating Interest
Balance updated with interest at 4.0%.

    -    ACCOUNT MENU    -
1. Deposit
2. Withdraw
3. Calculate Interest
4. Display Balance
5. Display Details
6. Logout

Enter your choice: 2

Withdrawal Initiated
Enter Withdrawal Amount: 12000
Amount 12000.0 withdrawn successfully from Account Number 22.

    -    ACCOUNT MENU    -
1. Deposit
2. Withdraw
3. Calculate Interest
4. Display Balance
5. Display Details
6. Logout

Enter your choice: 6

Logged out successfully!

    -    MENU    -
1. Create Account
2. Login to Account
3. Display All
4. Exit

Enter your choice: 3

Displaying All Accounts:

+---------------------+------------------+--------------+--------+------------------+----------------------+
| Name                | Account Number   | Balance      | ROI    | Contact Number   | Address              |
+---------------------+------------------+--------------+--------+------------------+----------------------+
| asp                 | 21               | 14108.0      | 4.0    | 43443452         | nashik               |
| jar                 | 22               | 12021.91998  | 4.0    | 35342            | jalgaon              |
+---------------------+------------------+--------------+--------+------------------+----------------------+
    -    MENU    -
1. Create Account
2. Login to Account
3. Display All
4. Exit

Enter your choice: 4

Thank You for using the Bank System!
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java>  
 *
 */