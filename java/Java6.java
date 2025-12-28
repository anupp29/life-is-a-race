/*
 * Write a Java program to accept a file name and display number of
characters,words and lines in the files
 */

import java.io.*;
import java.util.Scanner;

public class Java6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name (with extension): ");
        String fileName = sc.nextLine();

        int charCount = 0, wordCount = 0, lineCount = 0;

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                lineCount++;

                charCount += line.length(); 
                String[] words = line.trim().split("\\s+");
                
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            br.close();

            System.out.println("\n----- FILE STATS -----");
            System.out.println("Number of Characters: " + charCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Lines: " + lineCount);

        } catch (IOException e) {
            System.out.println("File not found or error reading file.");
        }

        sc.close();
    }
}


/*
 * 
 * PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> java Java6
Enter file name (with extension): Java6.txt

----- FILE STATS -----
Number of Characters: 95
Number of Words: 17
Number of Lines: 7
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> 
 */