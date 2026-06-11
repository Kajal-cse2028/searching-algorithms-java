import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Array in which search will be performed
        int arr[] = {10, 20, 30, 40, 50};

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int position = -1; // Stores index if element is found

        // Traverse the array one by one
        for (int i = 0; i < arr.length; i++) {

            // Check if current element matches the key
            if (arr[i] == key) {
                position = i;
                break; // Stop searching once found
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
