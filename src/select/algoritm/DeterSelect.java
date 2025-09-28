package select.algoritm;

import java.util.Arrays;

class DeterSelect {

    private static Object select;

    public static void setSelect(Object select) {
        DeterSelect.select = select;
    }

    void testSmallArray() {
        int[] arr = {3, 1, 4, 2, 7};
        boolean equals = equals(3, DeterSelect.select(arr, 2));
    }

    static int select(int[] arr, int i) {
        Arrays.sort(arr);
        return arr[i];
    }

    private boolean equals(int expected, int actual) {
        return expected == actual;
    }

    void testMedianOdd() {
        int[] arr = {9, 2, 6, 1, 6, 3, 8};
        int medianIndex = arr.length / 2;
        int expected = Arrays.stream(arr).sorted().toArray()[medianIndex];
        equals(expected, DeterSelect.select(arr, medianIndex));
    }

    void testMedianEven() {
        int[] arr = {10, 40, 30, 20};
        int medianIndex = arr.length / 2;
        int expected = (Arrays.stream(arr).sorted().toArray()[medianIndex - 1] +
                Arrays.stream(arr).sorted().toArray()[medianIndex]) / 2;
        equals(expected, DeterSelect.select(arr, medianIndex - 1)); // Please pay attention to the index
    }

    void testKth() {
        int[] arr = {50, 40, 30, 20, 10};
        equals(10, DeterSelect.select(arr, 0));
        equals(50, DeterSelect.select(arr, arr.length - 1));
    }
}
