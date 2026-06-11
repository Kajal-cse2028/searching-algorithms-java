// 📖 Concept

// Interpolation Search improves Binary Search by estimating the likely position of the target.

// Works best when data is uniformly distributed.

// Formula

//            key−arr[low])(high−low)
// pos = low+ _________________________
//              (arr[high]−arr[low]

	​
import java.util.Scanner;

public class InterpolationSearch {

    public static int interpolationSearch(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high &&
                key >= arr[low] &&
                key <= arr[high]) {

            // Estimate position
            int pos = low +
                    ((key - arr[low]) * (high - low))
                    / (arr[high] - arr[low]);

            if (arr[pos] == key)
                return pos;

            if (arr[pos] < key)
                low = pos + 1;
            else
                high = pos - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        int arr[] = {10,20,30,40,50,60,70,80,90};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int result = interpolationSearch(arr, key);

        if(result != -1)
            System.out.println("Element found at index " + result);
        else
            System.out.println("Element not found");

        sc.close();
    }
}
