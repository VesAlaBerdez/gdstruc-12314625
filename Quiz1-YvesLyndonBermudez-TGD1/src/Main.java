public class Main {
    public static void main(String[] args) {
        //Setting Up Array for Bubble Sort
        int[] numbers1 = new int[10];

        numbers1[0] = 25;
        numbers1[1] = -3;
        numbers1[2] = 5;
        numbers1[3] = 10;
        numbers1[4] = 38;
        numbers1[5] = 62;
        numbers1[6] = 20;
        numbers1[7] = -8;
        numbers1[8] = 173;
        numbers1[9] = 65;

        System.out.print("\nBubble Sort");

        // Before Bubble Sorting
        System.out.print("\n\nBefore Bubble Sorting: ");
        printArrayElements(numbers1);

        // Bubble Sort(numbers);
        bubbleSort(numbers1);

        // After Bubble Sorting
        System.out.print("\n\nAfter Bubble Sorting: ");
        printArrayElements(numbers1);

        // Reset and Set Array for Selection Array
        int[] numbers2 = new int[10];

        numbers2[0] = 25;
        numbers2[1] = -3;
        numbers2[2] = 5;
        numbers2[3] = 10;
        numbers2[4] = 38;
        numbers2[5] = 62;
        numbers2[6] = 20;
        numbers2[7] = -8;
        numbers2[8] = 173;
        numbers2[9] = 65;

        System.out.print("\n\n\nSelection Sort");

        // Before Selection Sorting
        System.out.print("\n\nBefore Selection Sorting: ");
        printArrayElements(numbers2);

        // Selection Sort
        selectionSort(numbers2);

        // After Selection Sorting
        System.out.print("\n\nAfter Selection Sorting: ");
        printArrayElements(numbers2);
        System.out.print("\n");
    }

    private static void bubbleSort(int[] nums) {
        for (int unsortedPartitionIndex = nums.length - 1; unsortedPartitionIndex > 0; unsortedPartitionIndex--) {
            for (int i = 0; i < unsortedPartitionIndex; i++){
                // Adjusted for Descending Order, Swap the 2 adjacent elements
                if (nums[i] < nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] nums) {
        for (int firstUnsortedIndex = 0; firstUnsortedIndex < nums.length - 1; firstUnsortedIndex++) {
            // Assumes the first element of the unsorted section is the smallest.
            int smallest = firstUnsortedIndex;

            // Since it is sorting in Descending order. It's Adjusted to look for the largest value instead
            for (int i = firstUnsortedIndex + 1; i < nums.length; i++) {
               if (nums[i] > nums[smallest]) {
                   smallest = i;
               }
            }

            // Swaps the value of smallest with value of firstUnsortedIndex
            if (smallest != firstUnsortedIndex) {
                int temp = nums[smallest];
                nums[smallest] = nums[firstUnsortedIndex];
                nums[firstUnsortedIndex] = temp;
            }
        }
    }

    private static void printArrayElements(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

