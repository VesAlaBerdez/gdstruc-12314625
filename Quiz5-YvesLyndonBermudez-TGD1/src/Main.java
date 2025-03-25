public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597};
        int searchValue = 610;

        // Print the Output of the YvesinacciJumpSearch Algorithm
        int index = YvesinacciJumpSearch(nums, searchValue);

        // Checks if the Searched value is found or not found in the array
        if (index != -1) {
            System.out.println("\nThe Fibonacci Number " + searchValue + " is at index " + index);
        } else {
            System.out.println("\nValue not found in the array.");
        }
    }

    public static int YvesinacciJumpSearch(int[] arr, int value) {
        int n = arr.length;

        // Initialize Fibonacci numbers
        int fibM_minus_2 = 0;
        int fibM_minus_1 = 1;
        int fibM = fibM_minus_1 + fibM_minus_2;

        // Finds the smallest Fibonacci number greater than or equal to n
        while (fibM < n) {
            fibM_minus_2 = fibM_minus_1;
            fibM_minus_1 = fibM;
            fibM = fibM_minus_1 + fibM_minus_2;
        }

        // Marks the eliminated range from front
        int offset = -1;

        while (fibM > 1) {
            // Check the right index using the Fibonacci numbers
            int i = Math.min(offset + fibM_minus_2, n - 1);

            // If the value is greater, move forward
            if (arr[i] < value) {
                fibM = fibM_minus_1;
                fibM_minus_1 = fibM_minus_2;
                fibM_minus_2 = fibM - fibM_minus_1;
                offset = i;
            }
            // If the value is smaller, move backward
            else if (arr[i] > value) {
                fibM = fibM_minus_2;
                fibM_minus_1 -= fibM_minus_2;
                fibM_minus_2 = fibM - fibM_minus_1;
            }
            // Value found
            else {
                return i;
            }
        }

        // Last check if value matches
        if (fibM_minus_1 == 1 && arr[offset + 1] == value) {
            return offset + 1;
        }

        // Return -1 if the value is not found
        return -1;
    }
}