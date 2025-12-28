package calculator;

public class Fibonacci {
    public static int fibo(int a) {
        if (a <= 1) {
            return a;
        }

        int fib1 = 0;
        int fib2 = 1;
        int fib = 0;

        for (int i = 2; i <= a+1; i++) {
            fib = fib1 + fib2;
            System.out.print(fib + " ");
            fib1 = fib2;
            fib2 = fib;
        }
        return fib;
    }
}