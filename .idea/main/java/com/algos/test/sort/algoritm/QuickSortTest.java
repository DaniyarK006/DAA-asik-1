package sort.algoritm;

import java.util.Arrays;

public class QuickSortTest {

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Find the index of the separator
            int partitionIndex = partition(array, low, high);

            // Recursively sort the elements before and after the separator
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    // Method for splitting an array and finding the index of the separator
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // Index of low element

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // swap places
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        System.out.println("Original massive: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted massive: " + Arrays.toString(array));
    }
}
