package select.algoritm;

import java.util.Arrays;

class DeterSelectTest {

    public static void main(String[] args) {
        DeterSelect ds = new DeterSelect();
        ds.testSmallArray();
        ds.testMedianOdd();
        ds.testMedianEven();
        ds.testKth();
    }

    void testSmallArray() {
        int[] arr = {3, 1, 4, 2, 7};
        DeterSelect.setSelect(new DeterSelect());
        boolean equals = equals(3, DeterSelect.select(arr, 2));
        System.out.println("testSmallArray: " + (equals ? "Passed" : "Failed"));
    }

    void testMedianOdd() {
        int[] arr = {9, 2, 6, 1, 6, 3, 8};
        int medianIndex = arr.length / 2;
        int expected = Arrays.stream(arr).sorted().toArray()[medianIndex];
        boolean equals = equals(expected, DeterSelect.select(arr, medianIndex));
        System.out.println("testMedianOdd: " + (equals ? "Passed" : "Failed"));
    }

    void testMedianEven() {
        int[] arr = {10, 40, 30, 20};
        int medianIndex = arr.length / 2;
        int expected = (Arrays.stream(arr).sorted().toArray()[medianIndex - 1] +
                Arrays.stream(arr).sorted().toArray()[medianIndex]) / 2;
        boolean equals = equals(expected, DeterSelect.select(arr, medianIndex - 1)); // Attention for index
        System.out.println("testMedianEven: " + (equals ? "Passed" : "Failed"));
    }

    void testKth() {
        int[] arr = {50, 40, 30, 20, 10};
        boolean firstEquals = equals(10, DeterSelect.select(arr, 0));
        boolean lastEquals = equals(50, DeterSelect.select(arr, arr.length - 1));
        System.out.println("testKth: " + (firstEquals && lastEquals ? "Passed" : "Failed"));
    }

    private boolean equals(int expected, int actual) {
        return expected == actual;
    }
}
