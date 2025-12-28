/*
 * Write a Java program to implement a producer-consumer problem using the
wait() and notify() methods for thread synchronization.
 */

import java.util.Scanner;

class Buffer {
    private int[] buffer = new int[5];
    private int front = 0, rear = 0, count = 0;

    public synchronized void produce() {
        if (count == 5) {
            System.out.println("Buffer full!");
            return;
        }
        buffer[rear] = rear + 1;
        rear = (rear + 1) % 5;
        count++;
        System.out.println("Produced. Items in buffer: " + count);
        notify();
    }

    public synchronized void consume() {
        if (count == 0) {
            System.out.println("Buffer empty!");
            return;
        }
        front = (front + 1) % 5;
        count--;
        System.out.println("Consumed. Items in buffer: " + count);
        notify();
    }
}

public class Java10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Buffer buffer = new Buffer();

        while (true) {
            System.out.println("1. Produce\n2. Consume\n3. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                buffer.produce();
            } else if (choice == 2) {
                buffer.consume();
            } else {
                break;
            }
        }
        sc.close();
    }
}


/*
 * PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> javac java10.java
PS C:\Users\hp\Desktop\CARP\life-is-a-race\java> java Java10      
1. Produce
2. Consume
3. Exit
1
Produced. Items in buffer: 1
1. Produce
2. Consume
3. Exit
1
Produced. Items in buffer: 2
1. Produce
2. Consume
3. Exit
2
Consumed. Items in buffer: 1
1. Produce
2. Consume
3. Exit
1
Produced. Items in buffer: 2
1. Produce
2. Consume
3. Exit
2
Consumed. Items in buffer: 1
1. Produce
2. Consume
3. Exit
1
Produced. Items in buffer: 2
1. Produce
2. Consume
3. Exit
2
Consumed. Items in buffer: 1
1. Produce
2. Consume
3. Exit
1
Produced. Items in buffer: 2
1. Produce
2. Consume
3. Exit
1
Produced. Items in buffer: 3
1. Produce
2. Consume
3. Exit
1
Produced. Items in buffer: 4
1. Produce
2. Consume
3. Exit
1
Produced. Items in buffer: 5
1. Produce
2. Consume
3. Exit
1
Buffer full!
1. Produce
2. Consume
3. Exit
2
Consumed. Items in buffer: 4
1. Produce
2. Consume
3. Exit
2
Consumed. Items in buffer: 3
1. Produce
2. Consume
3. Exit
2
Consumed. Items in buffer: 2
1. Produce
2. Consume
3. Exit
2
Consumed. Items in buffer: 1
1. Produce
2. Consume
3. Exit
2
Consumed. Items in buffer: 0
1. Produce
2. Consume
3. Exit
2
Buffer empty!
1. Produce
2. Consume
3. Exit

 */