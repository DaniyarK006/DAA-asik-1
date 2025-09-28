package sort.algoritm;

import org.junit.Test;
import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        int[] array = {38, 27, 43, 3, 9, 82, 11};
        MergeSort.mergeSort(array);
        int[] expected = {3, 9, 11, 27, 38, 43, 82};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortEmptyArray() {
        int[] array = {};
        MergeSort.mergeSort(array);
        int[] expected = {};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortSingleElement() {
        int[] array = {5};
        MergeSort.mergeSort(array);
        int[] expected = {5};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortAlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        MergeSort.mergeSort(array);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortReverseOrder() {
        int[] array = {5, 4, 3, 2, 1};
        MergeSort.mergeSort(array);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, array);
    }
}
