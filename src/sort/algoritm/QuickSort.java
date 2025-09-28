package sort.algoritm;

import metrics.algoritm.Metrics;

import java.util.Collections;

public class QuickSort {

    // Method for sorting an array
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Метод для разделения массива
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // The main method for testing
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        int n = array.length;

        quickSort(array, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static int sort(int[] arr, Metrics metrics) {
        int high = 0;
        int pivot = arr[high];
        int low = 0;
        int i = low - 1;

        Collections ArrayUtils = null;
        for (int j = low; j < high; j++) {
            metrics.incComparisons();
            if (arr[j] <= pivot) {
                i++;
                ArrayUtils.swap(Collections.singletonList(arr), i, j);
                metrics.incAllocations();
            }
        }
        ArrayUtils.swap(Collections.singletonList(arr), i + 1, high);
        metrics.incAllocations();

        return i + 1;

    }
}
