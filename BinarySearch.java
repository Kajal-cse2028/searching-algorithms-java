import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Sorted array (Binary Search requires sorted data)
        int arr[] = {10, 20, 30, 40, 50, 60, 70};

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int low = 0;                  // First index
        int high = arr.length - 1;    // Last index
        int position = -1;            // Stores index if found

        // Continue until search space becomes empty
        while (low <= high) {

            // Find middle index
            int mid = (low + high) / 2;

            // If middle element is the key
            if (arr[mid] == key) {
                position = mid;
                break;
            }

            // If key is greater, search right half
            else if (key > arr[mid]) {
                low = mid + 1;
            }

            // If key is smaller, search left half
            else {
                high = mid - 1;
            }
        }

        // Display result
        if (position != -1) {
            System.out.println("Element found at index: " + position);
        } else {
            System.out.println("Element not found.");
        }

        sc.close();
    }
}



// Working Example

// Array:

// [10, 20, 30, 40, 50, 60, 70]

// Search Key = 50

// Step 1:
// Low=0, High=6
// Mid=(0+6)/2 = 3
// arr[3]=40

// 50 > 40
// Search right half

// Step 2:
// Low=4, High=6
// Mid=(4+6)/2 = 5
// arr[5]=60

// 50 < 60
// Search left half

// Step 3:
// Low=4, High=4
// Mid=4
// arr[4]=50

// Found!

// Output:
// Element found at index: 4
