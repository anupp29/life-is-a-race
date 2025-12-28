/*
Write a Java program to perform different operations on String.
i. charAt()
ii. compareTo()
iii. concat()
iv. equals()
CO1
v. replace()
vi. split()
vii. trim()
*/


import java.util.Scanner;

public class Java3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1, str2;
        int choice = 0;

        System.out.println("Enter the main string:");
        str1 = scanner.nextLine();

        while (choice != 11) {
            System.out.println("\n--- String Operations Menu ---");
            System.out.println("1. charAt()");
            System.out.println("2. compareTo()");
            System.out.println("3. concat()");
            System.out.println("4. equals()");
            System.out.println("5. replace()");
            System.out.println("6. split()");
            System.out.println("7. trim()");
            System.out.println("8. toLowerCase()");
            System.out.println("9. toUpperCase()");
            System.out.println("10. length()");
            System.out.println("11. Exit");
            System.out.print("Select an option (1-11): ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); 
                    if (index >= 0 && index < str1.length()) {
                        System.out.println("Character at index " + index + ": " + str1.charAt(index));
                    } else {
                        System.out.println("Error: Index out of bounds.");
                    }
                    break;
                case 2:
                    System.out.print("Enter another string to compare: ");
                    str2 = scanner.nextLine();
                    System.out.println("Comparison result: " + str1.compareTo(str2));
                    break;
                case 3:
                    System.out.print("Enter another string to concatenate: ");
                    str2 = scanner.nextLine();
                    System.out.println("Concatenated string: " + str1.concat(str2));
                    break;
                case 4:
                    System.out.print("Enter another string to check equality: ");
                    str2 = scanner.nextLine();
                    System.out.println("Strings are equal: " + str1.equals(str2));
                    break;
                case 5:
                    System.out.print("Enter character to replace: ");
                    char oldChar = scanner.nextLine().charAt(0);
                    System.out.print("Enter new character: ");
                    char newChar = scanner.nextLine().charAt(0);
                    System.out.println("Replaced string: " + str1.replace(oldChar, newChar));
                    break;
                case 6:
                    System.out.print("Enter delimiter to split: ");
                    String delimiter = scanner.nextLine();
                    String[] parts = str1.split(delimiter);
                    System.out.println("Split parts:");
                    for (String part : parts) {
                        System.out.println(part);
                    }
                    break;
                case 7:
                    System.out.println("Trimmed string: '" + str1.trim() + "'");
                    break;
                case 8:
                    System.out.println("Lowercase string: " + str1.toLowerCase());
                    break;
                case 9:
                    System.out.println("Uppercase string: " + str1.toUpperCase());
                    break;
                case 10:
                    System.out.println("Length of string: " + str1.length());
                    break;
                case 11:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}


/*
 * 
 * Enter the main string:
Rja Kolhe 321

--- String Operations Menu ---
1. charAt()
2. compareTo()
3. concat()
4. equals()
5. replace()
6. split()
7. trim()
8. toLowerCase()
9. toUpperCase()
10. length()
11. Exit
Select an option (1-11): 1
Enter index: 13
Error: Index out of bounds.

--- String Operations Menu ---
1. charAt()
2. compareTo()
3. concat()
4. equals()
5. replace()
6. split()
7. trim()
8. toLowerCase()
9. toUpperCase()
10. length()
11. Exit
Select an option (1-11): 1
Enter index: 11
Character at index 11: 2

--- String Operations Menu ---
1. charAt()
2. compareTo()
3. concat()
4. equals()
5. replace()
6. split()
7. trim()
8. toLowerCase()
9. toUpperCase()
10. length()
11. Exit
Select an option (1-11): 2
Enter another string to compare: Raj
Comparison result: 9

--- String Operations Menu ---
1. charAt()
2. compareTo()
3. concat()
4. equals()
5. replace()
6. split()
7. trim()
8. toLowerCase()
9. toUpperCase()
10. length()
11. Exit
Select an option (1-11): 3
Enter another string to concatenate: ent
Concatenated string: Rja Kolhe 321ent

--- String Operations Menu ---
1. charAt()
2. compareTo()
3. concat()
4. equals()
5. replace()
6. split()
7. trim()
8. toLowerCase()
9. toUpperCase()
10. length()
11. Exit
Select an option (1-11): 4
Enter another string to check equality: Raj
Strings are equal: false

--- String Operations Menu ---
1. charAt()
2. compareTo()
3. concat()
4. equals()
5. replace()
6. split()
7. trim()
8. toLowerCase()
9. toUpperCase()
10. length()
11. Exit
Select an option (1-11): 5
Enter character to replace: 3
Enter new character: 5
Replaced string: Rja Kolhe 521

--- String Operations Menu ---
1. charAt()
2. compareTo()
3. concat()
4. equals()
5. replace()
6. split()
7. trim()
8. toLowerCase()
9. toUpperCase()
10. length()
11. Exit
Select an option (1-11): 5
Enter character to replace:  
Enter new character: $
Replaced string: Rja$Kolhe$321

--- String Operations Menu ---
1. charAt()
2. compareTo()
3. concat()
4. equals()
5. replace()
6. split()
7. trim()
8. toLowerCase()
9. toUpperCase()
10. length()
11. Exit
Select an option (1-11): 7
Trimmed string: 'Rja Kolhe 321'

--- String Operations Menu ---
1. charAt()
2. compareTo()
3. concat()
4. equals()
5. replace()
6. split()
7. trim()
8. toLowerCase()
9. toUpperCase()
10. length()
11. Exit
Select an option (1-11): 8
Lowercase string: rja kolhe 321

--- String Operations Menu ---
1. charAt()
2. compareTo()
3. concat()
4. equals()
5. replace()
6. split()
7. trim()
8. toLowerCase()
9. toUpperCase()
10. length()
11. Exit
Select an option (1-11): 9
Uppercase string: RJA KOLHE 321

--- String Operations Menu ---
1. charAt()
2. compareTo()
3. concat()
4. equals()
5. replace()
6. split()
7. trim()
8. toLowerCase()
9. toUpperCase()
10. length()
11. Exit
Select an option (1-11): 10
Length of string: 13

--- String Operations Menu ---
1. charAt()
2. compareTo()
3. concat()
4. equals()
5. replace()
6. split()
7. trim()
8. toLowerCase()
9. toUpperCase()
10. length()
11. Exit
Select an option (1-11): 11
Exiting...
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> 
 */