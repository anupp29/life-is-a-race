/*
 * Write a Java program to create calculator for performing arithmetic
operations using packages 
 */
import calculator.Addition;
import calculator.Substraction;
import calculator.Multiplication;
import calculator.Factorial;
import calculator.Fibonacci;
import java.util.Scanner;

import calculator.Division;
import java.util.Scanner;
public class Java8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("First: ");
		int num1=scanner.nextInt();
		System.out.print("Second: ");
		int num2=scanner.nextInt();
		
		System.out.println("Addition: "+Addition.add(num1,num2));
		System.out.println("Subtraction: "+Substraction.subtract(num1,num2));
		System.out.println("Multiplication: "+Multiplication.multiply(num1,num2));
		System.out.println("Division: "+Division.divide(num1,num2));
		System.out.println("Factorial for 1st: "+Factorial.fact(num1));
		System.out.println("Factorial for 2nd: "+Factorial.fact(num2));
		System.out.println("Fibonacci for 1st: "+Fibonacci.fibo(num1));
		System.out.println("Fibonacci for 2nd: "+Fibonacci.fibo(num2));
}
}

/*
 * First: 4
Second: 5
Addition: 9
Subtraction: -1
Multiplication: 20
Division: 0.8
Factorial for 1st: 24
Factorial for 2nd: 120
1 2 3 5 Fibonacci for 1st: 5
1 2 3 5 8 Fibonacci for 2nd: 8
 */
		