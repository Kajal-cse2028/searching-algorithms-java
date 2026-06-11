// 📖 Concept

// Jump Search works on a sorted array. Instead of checking every element, it jumps by a fixed step size (usually √n).


import java.util.Scanner;

public class JumpSearch {

    public static int jumpSearch(int[] arr, int key) {

        int n = arr.length;

        // Calculate jump size
        int step = (int) Math.sqrt(n);

        int prev = 0;

        // Finding the block where the element may be present
        while (arr[Math.min(step, n) - 1] < key) {
            prev = step;
            step += (int) Math.sqrt(n);

            if (prev >= n)
                return -1;
        }

        // Linear search within the identified block
        while (arr[prev] < key) {
            prev++;

            if (prev == Math.min(step, n))
                return -1;
        }

        // Element found
        if (arr[prev] == key)
            return prev;

        return -1;
    }

    public static void main(String[] args) {

        int arr[] = {10,20,30,40,50,60,70,80,90};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int result = jumpSearch(arr, key);

        if(result != -1)
            System.out.println("Element found at index " + result);
        else
            System.out.println("Element not found");

        sc.close();
    }
}
