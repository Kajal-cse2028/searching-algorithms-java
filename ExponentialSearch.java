// 📖 Concept

// Exponential Search first finds a range where the element exists by repeatedly doubling the index.

// After finding the range, Binary Search is applied.

import java.util.Scanner;

public class ExponentialSearch {

    static int binarySearch(int[] arr, int low, int high, int key) {

        while(low <= high) {

            int mid = (low + high) / 2;

            if(arr[mid] == key)
                return mid;

            if(arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    static int exponentialSearch(int[] arr, int key) {

        int n = arr.length;

        if(arr[0] == key)
            return 0;

        int i = 1;

        // Double the index until range is found
        while(i < n && arr[i] <= key)
            i *= 2;

        return binarySearch(arr,
                i / 2,
                Math.min(i, n - 1),
                key);
    }

    public static void main(String[] args) {

        int arr[] = {10,20,30,40,50,60,70,80,90};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int result = exponentialSearch(arr, key);

        if(result != -1)
            System.out.println("Element found at index " + result);
        else
            System.out.println("Element not found");

        sc.close();
    }
}
