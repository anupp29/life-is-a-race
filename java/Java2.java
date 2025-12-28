/*Write a Java program to implement a producer-consumer problem using the
wait() and notify() methods for thread synchronization. */

import java.util.*;
class Shape{
	int l,b,s;
	double base,h,r;
	
	Shape(int l,int b){
		this.l = l;
		this.b = b;
	}
	Shape(int s){
		this.s = s;
	}
	Shape(double base,double h){
		this.base = base;
		this.h = h;
	}
	Shape(double r){
		this.r = r;
	}
	
	static void calcRec(Shape shape){
		System.out.println("Area of rectangle : " + shape.l*shape.b);
	}
	static void calcSq(Shape shape){
		System.out.println("Area of square : " + shape.s*shape.s);
	}
	static void calcTri(Shape shape){
		System.out.println("Area of triangle : " + 0.5*shape.base*shape.h);
	}
	static void calcCir(Shape shape){
		System.out.println("Area of circle : " + 22*shape.r*shape.r/7);
	}
}

public class Java2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int exit = 0;

        while (exit==0) {
            System.out.println("Choose an option:");
            System.out.println("1. Calculate Rectangle Area");
            System.out.println("2. Calculate Square Area");
            System.out.println("3. Calculate Circle Area");
            System.out.println("4. Calculate Triangle Area");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter length and breadth: ");
                    int length = scanner.nextInt();
                    int breadth = scanner.nextInt();
                    Shape rectangle = new Shape(length, breadth);
                    Shape.calcRec(rectangle);
                    break;
                case 2:
                    System.out.print("Enter side: ");
                    int side = scanner.nextInt();
                    Shape square = new Shape(side);
                    Shape.calcSq(square);
                    break;
                case 3:
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    Shape circle = new Shape(radius);
                    Shape.calcCir(circle);
                    break;
                case 4:
                    System.out.print("Enter base and height: ");
                    double base = scanner.nextDouble();
                    double height = scanner.nextDouble();
                    Shape triangle = new Shape(base, height);
                    Shape.calcTri(triangle);
                    break;
                case 5:
                    exit = 1;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
} 

/*
 * PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> java Java2
Choose an option:
1. Calculate Rectangle Area
2. Calculate Square Area
3. Calculate Circle Area
4. Calculate Triangle Area
5. Exit
1
Enter length and breadth: 12 3 
Area of rectangle : 36
Choose an option:
1. Calculate Rectangle Area
2. Calculate Square Area
3. Calculate Circle Area
4. Calculate Triangle Area
5. Exit
2
Enter side: 3
Area of square : 9
Choose an option:
1. Calculate Rectangle Area
2. Calculate Square Area
3. Calculate Circle Area
4. Calculate Triangle Area
5. Exit
3
Enter radius: 7
Area of circle : 154.0
Choose an option:
1. Calculate Rectangle Area
2. Calculate Square Area
3. Calculate Circle Area
4. Calculate Triangle Area
5. Exit
4
Enter base and height: 4 5
Area of triangle : 10.0
Choose an option:
1. Calculate Rectangle Area
2. Calculate Square Area
3. Calculate Circle Area
4. Calculate Triangle Area
5. Exit
5
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> 
 */