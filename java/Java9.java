/*
 * Write a JAVA program to create User defined exception to check the
following conditions and throw the exception if the criterion does not met.
i. User has age between 18 and 55
ii. User has income between Rs. 50,000 –Rs. 1,00,000 per month
iii. User stays in Pune / Mumbai/ Bangalore / Chennai
iv. User has 4-wheeler
Accept age, Income, City, Vehicle from the user and check for the conditions
mentioned above.If any of the condition not met then throw the exception
 */
import java.util.*;

class InvalidUserException extends Exception {
    public InvalidUserException(String message) {
        super(message);
    }
}

public class Java9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Taking user inputs
            System.out.print("Enter your Age: ");
            int age = sc.nextInt();
            System.out.print("Enter your Monthly Income: ");
            double income = sc.nextDouble();
            sc.nextLine(); // consume leftover newline
            System.out.print("Enter your City (Pune/Mumbai/Bangalore/Chennai): ");
            String city = sc.nextLine();
            System.out.print("Do you own a 4-wheeler? (yes/no): ");
            String vehicle = sc.nextLine();

            // Checking conditions one by one
            if (age < 18 || age > 55) {
                throw new InvalidUserException("Age must be between 18 and 55.");
            }

            if (income < 50000 || income > 100000) {
                throw new InvalidUserException("Income must be between Rs.50,000 and Rs.1,00,000 per month.");
            }

            if (!(city.equalsIgnoreCase("Pune") || city.equalsIgnoreCase("Mumbai") ||
                  city.equalsIgnoreCase("Bangalore") || city.equalsIgnoreCase("Chennai"))) {
                throw new InvalidUserException("City must be Pune, Mumbai, Bangalore or Chennai.");
            }

            if (!vehicle.equalsIgnoreCase("yes")) {
                throw new InvalidUserException("User must own a 4-wheeler.");
            }

            // If all conditions are satisfied
            System.out.println("\nAll conditions are satisfied. User is valid!");

        } catch (InvalidUserException e) {
            System.out.println("\nException: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input type!");
        } finally {
            sc.close();
        }
    }
}


/*
 * PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> javac java9.java
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> java Java9
Enter your Age: 17
Enter your Monthly Income: 12000
Enter your City (Pune/Mumbai/Bangalore/Chennai): Pune
Do you own a 4-wheeler? (yes/no): yes

Exception: Age must be between 18 and 55.
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> java Java9
Enter your Age: 19
Enter your Monthly Income: 40000
Enter your City (Pune/Mumbai/Bangalore/Chennai): Pune
Do you own a 4-wheeler? (yes/no): yes

Exception: Income must be between Rs.50,000 and Rs.1,00,000 per month.
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> java Java9
Enter your Age: 19
Enter your Monthly Income: 50000
Enter your City (Pune/Mumbai/Bangalore/Chennai): Nashik
Do you own a 4-wheeler? (yes/no): yes

Exception: City must be Pune, Mumbai, Bangalore or Chennai.
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> java Java9
Enter your Age: 19
Enter your Monthly Income: 80000
Enter your City (Pune/Mumbai/Bangalore/Chennai): Pune
Do you own a 4-wheeler? (yes/no): no

Exception: User must own a 4-wheeler.
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> java Java9
Enter your Age: 19
Enter your Monthly Income: 60000
Enter your City (Pune/Mumbai/Bangalore/Chennai): Pune
Do you own a 4-wheeler? (yes/no): yes

All conditions are satisfied. User is valid!
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> 
 */