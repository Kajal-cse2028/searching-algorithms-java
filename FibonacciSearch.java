// 📖 Concept

// Fibonacci Search uses Fibonacci numbers to divide the array instead of using midpoints.

// Useful when division operations are costly.

import java.util.Scanner;

public class FibonacciSearch {

    static int fibonacciSearch(int[] arr, int key) {

        int n = arr.length;

        int fib2 = 0;   // (m-2)th Fibonacci
        int fib1 = 1;   // (m-1)th Fibonacci
        int fib = fib1 + fib2;

        // Find smallest Fibonacci number >= n
        while (fib < n) {
            fib2 = fib1;
            fib1 = fib;
            fib = fib1 + fib2;
        }

        int offset = -1;

        while (fib > 1) {

            int i = Math.min(offset + fib2, n - 1);

            if (arr[i] < key) {
                fib = fib1;
                fib1 = fib2;
                fib2 = fib - fib1;
                offset = i;
            }

            else if (arr[i] > key) {
                fib = fib2;
                fib1 = fib1 - fib2;
                fib2 = fib - fib1;
            }

            else {
                return i;
            }
        }

        if (fib1 == 1 &&
            offset + 1 < n &&
            arr[offset + 1] == key)
            return offset + 1;

        return -1;
    }

    public static void main(String[] args) {

        int arr[] = {10,20,30,40,50,60,70,80,90};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int result = fibonacciSearch(arr, key);

        if(result != -1)
            System.out.println("Element found at index " + result);
        else
            System.out.println("Element not found");

        sc.close();
    }
}
