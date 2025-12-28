/*
 * Write Java program to create a super class called “Shape” that receives the
dimensions of objects. It also defines a method called area that computes the
area of an object. The program derives two subclasses from “Shape”. Each of
the sub class overrides area() so that it returns the area of a rectangle and a
triangle respectively
 */

import java.util.Scanner;

class Shape {
    double width, height;

    Shape(double w, double h) {
        width = w;
        height = h;
    }

    double area() {
        return 0; // Default implementation
    }
}

class Rectangle extends Shape {
    Rectangle(double w, double h) {
        super(w, h);
    }

    @Override
    double area() {
        return width * height;
    }
}
class Triangle extends Shape {
    Triangle(double w, double h) {
        super(w, h);
    }

    @Override
    double area() {
        return (width * height) / 2;
    }
}


public class Java4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose shape:");
        System.out.println("1. Rectangle");
        System.out.println("2. Triangle");
        System.out.print("Enter choice (1 or 2): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter length of Rectangle: ");
            double length = sc.nextDouble();
            System.out.print("Enter breadth of Rectangle: ");
            double breadth = sc.nextDouble();
            Rectangle rect = new Rectangle(length, breadth);
            System.out.println("Area of Rectangle: " + rect.area());
        } else if (choice == 2) {
            System.out.print("Enter base (width) of Triangle: ");
            double base = sc.nextDouble();
            System.out.print("Enter height of Triangle: ");
            double height = sc.nextDouble();
            Triangle tri = new Triangle(base, height);
            System.out.println("Area of Triangle: " + tri.area());
        } else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }
}

/*
 *  C:\Users\hp\Desktop\CARP\life-is-a-race\java> java Java4
Choose shape:
1. Rectangle
2. Triangle
Enter choice (1 or 2): 1
Enter length of Rectangle: 34
Enter breadth of Rectangle: 7
Area of Rectangle: 238.0
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> java Java4
Choose shape:
1. Rectangle
2. Triangle
Enter choice (1 or 2): 2 
Enter base (width) of Triangle: 4
Enter height of Triangle: 7
Area of Triangle: 14.0
 */