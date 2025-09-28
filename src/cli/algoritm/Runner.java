package cli.algoritm;

import closest.algoritm.ClosestPair;
import closest.algoritm.PairClosest;
import closest.algoritm.Point;
import metrics.algoritm.Metrics;
import sort.algoritm.MergeSort;
import sort.algoritm.QuickSort;

import java.util.Random;

public class Runner {

    public static void run(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java Runner <algorithm> <n> [<k>]");
            return;
        }

        String algo = args[0].toLowerCase();
        int n = Integer.parseInt(args[1]);
        int k = (algo.equals("select") && args.length > 2) ? Integer.parseInt(args[2]) : -1;

        Random rand = new Random(42);
        Metrics metrics = new Metrics();

        long start, end;
        Object result = null;

        switch (algo) {
            case "mergesort" -> {
                int[] arr = rand.ints(n, 0, 1_000_000).toArray();
                start = System.nanoTime();
                MergeSort.sort(arr, metrics);
                end = System.nanoTime();
                result = arr[0]; // just to print something
            }
            case "quicksort" -> {
                int[] arr = rand.ints(n, 0, 1_000_000).toArray();
                start = System.nanoTime();
                QuickSort.sort(arr, metrics);
                end = System.nanoTime();
                result = arr[0];
            }
            case "select" -> {
                int[] arr = rand.ints(n, 0, 1_000_000).toArray();
                if (k < 0 || k >= n) {
                    System.err.println("For 'select', provide a valid index k in range [0, n-1]");
                    return;
                }
                start = System.nanoTime();
                end = System.nanoTime();
            }
            case "closest" -> {
                Point[] pts = new Point[n];
                for (int i = 0; i < n; i++) {
                    pts[i] = new Point(rand.nextDouble() * 1000, rand.nextDouble() * 1000);
                }
                start = System.nanoTime();
                result = PairClosest.findClosestPair(pts, metrics);
                end = System.nanoTime();
            }
            default -> {
                System.err.println("Unknown algorithm: " + algo);
                return;
            }
        }

        long durationMs = (end - start) / 1_000_000;

        System.out.printf("Algorithm: %s%n", algo);
        System.out.printf("Input size: %d%n", n);
        if (k >= 0) {
            System.out.printf("k: %d%n", k);
        }
        System.out.printf("Result: %s%n", result);
        System.out.printf("Execution Time: %d ms%n", durationMs);
        System.out.printf("Metrics - Comparisons: %d, Allocations: %d, Max Recursion Depth: %d%n",
                metrics.getComparisons(),
                metrics.getAllocations(),
                metrics.getMaxRecursionDepth());
    }


    public static void printHeader() {
        System.out.println("AlgorithmName;RunTime(ms);Comparisons;Depth;Allocations");
    }
}
