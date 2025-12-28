/*
 * Write a Java program to create an interface named as“Sortable” with a
method sort() that sorts an array of integers in ascending order. Create two
classes BubbleSort and SelectionSort that implement the “Sortable” interface
and provide their own implementations of the sort() method

 */

import java.util.*;

interface Sortable {
    void sort(int[] array);
}

class BubbleSort implements Sortable {
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

class SelectionSort implements Sortable {
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}

public class Java7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking array input
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] array = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // Menu for sorting method
        System.out.println("Choose Sorting Method:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = sc.nextInt();

        Sortable sorter;

        switch (choice) {
            case 1:
                sorter = new BubbleSort();
                sorter.sort(array);
                System.out.println("Array after Bubble Sort: " + Arrays.toString(array));
                break;
            case 2:
                sorter = new SelectionSort();
                sorter.sort(array);
                System.out.println("Array after Selection Sort: " + Arrays.toString(array));
                break;
            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
